package com.putao_seo.api.controller;


import com.putao_seo.api.entity.*;
import com.putao_seo.api.service.ArticleService;
import com.putao_seo.api.service.CategoryService;
import com.putao_seo.api.utils.BaseBizResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

import static com.putao_seo.api.constants.CommonConstants.*;

@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(value = "/article", produces = {"application/json;charset=UTF-8"})
public class AtricleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    @Qualifier("appStringRedisTemplate")
    StringRedisTemplate appRedis;

    /**
     * 获取分类id为 categoryId（包含其下所有子类）下的所有的文章列表
     *
     * @param categoryId
     * @param pageNum
     * @return
     */
    @ApiOperation(value = "获取分类id为 categoryId（包含其下所有子类）下的所有的文章列表", notes = "")
    @ApiImplicitParam(name = "categoryId", value = "分类id", paramType = "path", required = true)
    @GetMapping(value = "/list/{categoryId}")
    public BaseBizResult<Map<String, Object>> getArticleListByCategoryId(@PathVariable("categoryId") Integer categoryId,
                                                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        try {
            // TODO 这里可以和前端商量让他们直接穿pidPath过来，免得重查一次
            // 重查一次主要是为了获得该分类的 pidPath
            Category category = categoryService.getCategoryById(categoryId);
            List<ArticleBrief> articleBriefList = new LinkedList<>();
            Long count = Long.valueOf(0);

            List<BaseObj> baseObjList = new LinkedList<>();
            String categoryPathName = "";
            String categoryPath = "";
            if (category != null){

                List<Category> subCategory = categoryService.getSubCategoryById(categoryId,false);
                category.setSubCategory(subCategory);

                //  获取categoryId下的子分类id列表 ：categoryIdList,包含了孙子分类（因为要包含孙子分类下的文章）
                List<Integer> categoryIdList = categoryService.getSubCategoryIdListById(categoryId, true);
                // categoryId自己的也获取
                categoryIdList.add(categoryId);

                // 获取categoryId在 categoryIdList中的 文章列表
                articleBriefList = articleService.getArticleBriefListByCategoryIdList(categoryIdList, pageNum, pageSize);
                count = articleService.countArticleListByCategoryIdList(categoryIdList);

                // 分类路径
                categoryPath = StringUtils.isEmpty(category.getPidPath()) ? String.valueOf(category.getId()) : (category.getPidPath() + "_" + category.getId());
                String[] categoryArray = categoryPath.split("_");

                for (int i = 0;i<categoryArray.length;i++){
                    BaseObj baseObj = new BaseObj();
                    baseObj.setCode(categoryArray[i]);
                    Category temp = categoryService.getCategoryById(Integer.valueOf(categoryArray[i]));
                    baseObj.setName(temp.getCategoryName());
                    baseObjList.add(baseObj);
                }
            }

            map.put("list", articleBriefList);
            map.put("category", category);
            map.put("count", count);

            map.put("categoryPath", baseObjList);

            return BaseBizResult.success(map);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 首页 首页下方
     * 分类文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "首页下方分类以及文章列表", notes = "")
    @GetMapping(value = "/list")
    public BaseBizResult<List<Map<String, Object>>> getAllArticleList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        List<Map<String, Object>> resultList = new LinkedList();
        try {
            // 下方的分类文章列表
            Integer categoryLevel = DEFAULT_CATEGORY_LEVEL;
            // 一级分类的列表
            List<Category> oneLevelCategoList = categoryService.getCategoryListByLevel(categoryLevel);
            for (Category ele :
                    oneLevelCategoList) {
                Map<String, Object> eleMap = new HashMap<>();
                // 一级分类下面的子分类（包含孙子，重孙子。。。分类）
                List<Category> subCategoryList = categoryService.getSubCategoryById(ele.getId(), true);

                List<Integer> subCategoryIdList = new LinkedList<>();

                // 一级分类的文章也要查出来
                subCategoryIdList.add(ele.getId());

                for (Category category :
                        subCategoryList) {
                    subCategoryIdList.add(category.getId());
                }


                List<ArticleBrief> articleBriefList = articleService.getArticleBriefListByCategoryIdList(subCategoryIdList, pageNum, pageSize);
                long articleCount = articleService.countArticleListByCategoryIdList(subCategoryIdList);

                eleMap.put("category", ele);
                eleMap.put("subCategoryList", subCategoryList);
                eleMap.put("articleList", articleBriefList);
                eleMap.put("articleCount", articleCount);
                resultList.add(eleMap);
            }

            return BaseBizResult.success(resultList);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 文章详情
     * 每点击一次文章，就在 ARTICLE_HOT_CLICK_PREFIX + ":" + localDate.getYear()+":"+localDate.getMonthValue(); 中将该文章的次数加 1
     * @param articleId 文章id
     * @return
     */
    @ApiOperation(value = "根据文章id获取文章详情", notes = "每点击一次文章，文章的点击量加 1")
    @ApiImplicitParam(name = "articleId", value = "文章id", paramType = "path", required = true)
    @GetMapping(value = "/detail/{articleId}")
    public BaseBizResult<Map<String, Object>> queryDetail(@PathVariable(value = "articleId",required = true)Integer articleId) {
        try {
            Map<String, Object> map = new HashMap<>();

            //文章详情
            Article article = articleService.getArticleById(articleId);
            map.put("detail",article);

            Category category = categoryService.getCategoryById(article.getCategoryid());

            // TODO 当对分类进行删除时可能导致这里错误
            // 当对文章的分类可能被删除了！！！
            if(category != null){
                String categoryPidPath = StringUtils.isEmpty(category.getPidPath()) ? String.valueOf(category.getId()):
                        (category.getPidPath().replaceAll("_",",")) + "," + category.getId();

                String[] pidArray = categoryPidPath.split(",");

                StringBuilder categorPidPathNameBuilder = new StringBuilder();
                for (int i=0;i<pidArray.length;i++){
                    Category ele = categoryService.getCategoryById(Integer.valueOf(pidArray[i]));
                    if (i != (pidArray.length-1)){
                        categorPidPathNameBuilder.append(ele.getCategoryName()).append(",");
                    }else {
                        categorPidPathNameBuilder.append(ele.getCategoryName());
                    }
                }

                map.put("categoryPidPath", categoryPidPath);
                map.put("categoryPidPathName", categorPidPathNameBuilder.toString());
            }else {
                map.put("categoryPidPath", "");
                map.put("categoryPidPathName", "");
            }

            //  上一篇，下一篇文章
            List<ArticleBrief> nextArticleBriefList = articleService.getNextArticleBriefListByCategoryId(articleId,article.getCategoryid(),1,1);
            List<ArticleBrief> priorArticleBriefList = articleService.getPriorArticleBriefListByCategoryId(articleId,article.getCategoryid(),1,1);

            if (nextArticleBriefList !=null && nextArticleBriefList.size() > 0){
                map.put("next", nextArticleBriefList.get(0));
            }else {
                map.put("next", "");
            }

            if (priorArticleBriefList !=null && priorArticleBriefList.size() > 0){
                map.put("prior", priorArticleBriefList.get(0));
            }else {
                map.put("prior", "");
            }




            // 推荐文章列表
            List<ArticleBrief> recommendArticleList = articleService.getRecommendArticleBriefList();
            map.put("recommendArticleList", recommendArticleList);
            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 热门资料，   热门问答，当然也可以用于文章详情页下的文章推荐
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "文章推荐", notes = "文章推荐 ")
    @GetMapping(value = "/recommendList")
    public BaseBizResult<List<ArticleBrief>> getRecommendArticleList(
                                                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        try {

            // 重查一次主要是为了获得该分类的 pidPath
            List<ArticleBrief> articleBriefList = articleService.getRecommendArticleBriefList();

            return BaseBizResult.success(articleBriefList);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 热门资料，   热门问答，当然也可以用于文章详情页下的文章推荐
     * @param pageNum
     * @param pageSize
     * @return
     */
//    @ApiOperation(value = "文章推荐", notes = "文章推荐 ")
//    @GetMapping(value = "/recommend")
//    public BaseBizResult<Map<String, Object>> getRecommendArticleBriefList(@RequestParam(name = "title", required = true)String title,
//            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            // 重查一次主要是为了获得该分类的 pidPath
////            List<EsArticle> esArticleList = articleService.getArticleBriefFromElasticsearchByTitle(title,pageNum,pageSize);
//            Map esArticleList = articleService.search(EsArticle.class, title, pageNum, pageSize);
//            return BaseBizResult.success(esArticleList);
//        } catch (Exception e) {
//            return BaseBizResult.error(e.getMessage());
//        }
//    }

    /**
     * 热门问答
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "热门问答", notes = "热门问答分类下文章时间倒序排 ")
    @GetMapping(value = "/hotQuestion")
    public BaseBizResult<Map<String, Object>> getHotQuestionArticleList(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, Object> map = new HashMap<>();
        try {
            // 重查一次主要是为了防止分类被修改
            List<ArticleBrief> articleBriefList = articleService.getArticleBriefListByCategoryName(HOTQUESTION, pageNum, pageSize);
            Long count = articleService.countArticleBriefListByCategoryName(HOTQUESTION);
            map.put("list", articleBriefList);
            map.put("count", count);
            return BaseBizResult.success(map);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 热门资料
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "热门资料", notes = " ")
    @GetMapping(value = "/hotMaterial")
    public BaseBizResult<Map<String, Object>> getHotMaterialArticleList(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 重查一次主要是为了防止分类被修改
            List<ArticleBrief> articleBriefList = articleService.getArticleBriefListByCategoryName( HOTMATERIAL, pageNum, pageSize);
            Long count = articleService.countArticleBriefListByCategoryName(HOTMATERIAL);
            map.put("list", articleBriefList);
            map.put("count", count);
            return BaseBizResult.success(map);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 热门点击 每个月文章的点击量
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "热门点击", notes = "每个月文章的点击量排名 ")
    @GetMapping(value = "/hotclick")
    public BaseBizResult<Map<String,Object>> getHotClickArticleList(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        try {
            Map<String, Object> map = new HashMap<>();

            Integer from = (pageNum - 1)* pageSize;
            Integer end = pageNum * pageSize - 1;

            LocalDate localDate = LocalDate.now();
            // 每个月
            String hot_click_key = ARTICLE_HOT_CLICK_PREFIX + ":" + localDate.getYear()+":"+localDate.getMonthValue();
            long count = appRedis.opsForZSet().zCard(hot_click_key);

            Set<ZSetOperations.TypedTuple<String>> articleIdSet = appRedis.opsForZSet().reverseRangeWithScores(hot_click_key, from, end);
            Iterator<ZSetOperations.TypedTuple<String>> iterator = articleIdSet.iterator();
            List<ArticleBrief> articleBriefList = new LinkedList<>();
            while (iterator.hasNext()){
                try {
                    ZSetOperations.TypedTuple<String> next = iterator.next();
                    String idStr = String.valueOf(next.getValue());
                    ArticleBrief articleBrief = articleService.getArticleBriefById(Integer.valueOf(idStr));
                    if (articleBrief != null){
                        articleBriefList.add(articleBrief);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            map.put("list", articleBriefList);
            map.put("count", count);
            return BaseBizResult.success(map);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }


}
