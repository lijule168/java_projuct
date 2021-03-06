package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.*;
import com.putao_seo.api.mapper.ArticleMapper;
import com.putao_seo.api.service.ArticleService;
import com.putao_seo.api.service.CategoryService;
import com.putao_seo.api.utils.BaseBizResult;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import io.searchbox.core.search.sort.Sort;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    private JestClient jestClient;

    @Override
    public List<Article> getArticleListByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize) {

        int offset = (pageNum -1) * pageSize;

        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andCategoryidEqualTo(categoryId).andArticleStatusEqualTo(1);
        articleExample.setOrderByClause("createTime desc");
        articleExample.setOffset(offset);
        articleExample.setPageSize(pageSize);

        return articleMapper.selectByExample(articleExample);
    }

    @Override
    public long countArticleListByCategoryId(Integer categoryId) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andCategoryidEqualTo(categoryId).andArticleStatusEqualTo(1);
        return articleMapper.countByExample(articleExample);
    }

    @Override
    public List<ArticleBrief> getArticleBriefListByCategoryIdList(List<Integer> categoryIdList, Integer pageNum, Integer pageSize) {
        if (categoryIdList !=null && categoryIdList.size() > 0){
            int offset = (pageNum -1 )* pageSize;

            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andCategoryidIn(categoryIdList).andArticleStatusEqualTo(1);
            articleExample.setOrderByClause("createTime desc");
            articleExample.setOffset(offset);
            articleExample.setPageSize(pageSize);
            return articleMapper.selectBriefByExample(articleExample);
        }else {
            return null;
        }

    }

    /**
     * ?????? ?????? id??? articleId ???????????? categoryId ??? ????????????????????????????????????
     *
     * @param articleId
     * @param categoryId ??????id
     * @param pageNum    ??????
     * @param pageSize   ?????????
     * @return
     */
    @Override
    public List<ArticleBrief> getNextArticleBriefListByCategoryId(Integer articleId, Integer categoryId, Integer pageNum, Integer pageSize) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andArticleidGreaterThan(articleId).andCategoryidEqualTo(categoryId).andArticleStatusEqualTo(1);
        articleExample.setOrderByClause("createTime desc");
        int offset = (pageNum -1 )* pageSize;
        articleExample.setOffset(offset);
        articleExample.setPageSize(pageSize);
        return articleMapper.selectBriefByExample(articleExample);
    }

    /**
     * ?????? ?????? id??? articleId ???????????? categoryId ??? ????????? ????????????
     *
     * @param articleId
     * @param categoryId ??????id
     * @param pageNum    ??????
     * @param pageSize   ?????????
     * @return
     */
    @Override
    public List<ArticleBrief> getPriorArticleBriefListByCategoryId(Integer articleId, Integer categoryId, Integer pageNum, Integer pageSize) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andArticleidLessThan(articleId).andCategoryidEqualTo(categoryId).andArticleStatusEqualTo(1);
        articleExample.setOrderByClause("createTime desc");
        int offset = (pageNum -1 )* pageSize;
        articleExample.setOffset(offset);
        articleExample.setPageSize(pageSize);
        return articleMapper.selectBriefByExample(articleExample);
    }

    @Override
    public long countArticleListByCategoryIdList(List<Integer> categoryIdList) {
        if (categoryIdList != null && categoryIdList.size() > 0){
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andCategoryidIn(categoryIdList).andArticleStatusEqualTo(1);
            return articleMapper.countByExample(articleExample);
        }else {
            return 0;
        }

    }

    /**
     * ????????????id?????? ????????????
     *
     * @param articleId ??????id
     * @return
     */
    @Override
    public Article getArticleById(Integer articleId) {

        return articleMapper.selectByPrimaryKey(articleId);
    }

    /**
     * ????????????id?????? ????????????
     *
     * @param articleId ??????id
     * @return
     */
    @Override
    public ArticleBrief getArticleBriefById(Integer articleId) {
        return articleMapper.selectBriefByPrimaryKey(articleId);
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    @Override
    public List<ArticleBrief> getRecommendArticleBriefList() {

        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andArticleStatusEqualTo(1);
        articleExample.setOrderByClause("createTime desc");
        articleExample.setOffset((DEFAULT_PAGE_NUM - 1)*RECOMMEND_ARTICLE_SIZE);
        articleExample.setPageSize(RECOMMEND_ARTICLE_SIZE);

        return articleMapper.selectBriefByExample(articleExample);
    }

    /**
     * ?????? ????????? ??????????????????
     *
     * @param categoryName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ArticleBrief> getArticleBriefListByCategoryName(String categoryName, Integer pageNum, Integer pageSize) {
        // ?????????????????????id??????????????????????????????????????????????????????
        List<Category> categoryList = categoryService.getCategoryByName(categoryName);
        List<ArticleBrief> articleBriefList = new LinkedList<>();

        if (categoryList != null && categoryList.size() > 0){
            //  ??????categoryId???????????????id?????? ???categoryIdList,??????????????????????????????????????????????????????????????????
            List<Integer> categoryIdList = categoryService.getSubCategoryIdListById(categoryList.get(0).getId(), true);
            // categoryId??????????????????
            categoryIdList.add(categoryList.get(0).getId());
            // ??????categoryId??? categoryIdList?????? ????????????
            articleBriefList = getArticleBriefListByCategoryIdList(categoryIdList, pageNum, pageSize);
        }
        return articleBriefList;
    }

    /**
     * ?????? ????????? ??????????????????
     *
     * @param categoryName
     * @return
     */
    @Override
    public long countArticleBriefListByCategoryName(String categoryName) {
        // ?????????????????????id??????????????????????????????????????????????????????
        List<Category> categoryList = categoryService.getCategoryByName(categoryName);

        Long count = Long.valueOf(0);
        if (categoryList != null && categoryList.size() > 0){
            //  ??????categoryId???????????????id?????? ???categoryIdList,??????????????????????????????????????????????????????????????????
            List<Integer> categoryIdList = categoryService.getSubCategoryIdListById(categoryList.get(0).getId(), true);
            // categoryId??????????????????
            categoryIdList.add(categoryList.get(0).getId());
            // ??????categoryId??? categoryIdList?????? ????????????

            count = countArticleListByCategoryIdList(categoryIdList);

        }
        return count;
    }

//    /**
//     * @param title
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @Override
//    public List<EsArticle> getArticleBriefFromElasticsearchByTitle(String title, Integer pageNum, Integer pageSize) {
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));
//        //searchSourceBuilder.field("name");
//        searchSourceBuilder.query(QueryBuilders.matchQuery("title",title));
//        Search search = new Search.Builder(searchSourceBuilder.toString())
//                .addIndex(ARTICLE_INDEX).addType(ARTICLE_TYPE).build();
//        try {
//            JestResult result = jestClient.execute(search);
//            return result.getSourceAsObjectList(EsArticle.class);
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//        return null;
//    }


//    /**
//     * ?????????????????????????????????????????????????????????????????????
//     *
//     * @param classType
//     * @return
//     */
//    @Override
//    public Map<String, Object> search(Class classType, String title, Integer pageNum, Integer pageSize) {
//        Map<String,Object> map = new HashMap<>();
//        try {
//
//            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//            searchSourceBuilder.query(QueryBuilders.matchQuery("title",title));
//            Search search = new Search.Builder(searchSourceBuilder.toString())
//                    .addIndex(ARTICLE_INDEX).addType(ARTICLE_TYPE)
//                    .addSort(new Sort("createTime", Sort.Sorting.DESC))
//                    .setParameter("from", (pageNum - 1) * pageSize)
//                    .setParameter("size", pageSize)
//                    .build();
////            Search.Builder builder = new Search.Builder(QueryBuilders.matchQuery("title", title).toString());
////            builder.addIndex(ARTICLE_INDEX)
////                    .addType(ARTICLE_TYPE)
////                    .setParameter("from", (pageNum - 1) * pageSize)
////                    .setParameter("size", pageSize)
////            ;
////            builder.addSort(new Sort("createTime", Sort.Sorting.DESC));
//            JestResult jestResult = jestClient.execute(search);
//            List resultList = jestResult.getSourceAsObjectList(classType);
//            int hitCount = jestResult.getJsonObject().get("hits").getAsJsonObject().get("total").getAsInt();
//
//            map.put("count", hitCount);
//            map.put("list", resultList);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }

}
