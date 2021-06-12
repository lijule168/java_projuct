package com.putao_seo.api.controller;

import com.github.pagehelper.PageInfo;
import com.putao_seo.api.entity.*;
import com.putao_seo.api.service.*;
import com.putao_seo.api.utils.BaseBizResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

import static com.putao_seo.api.constants.CommonConstants.*;


@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(path = "/shop", produces = {"application/json;charset=UTF-8"})
public class ShopController {

    private static Logger logger = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    ShopService shopService;
    @Autowired
    CommentService commentService;
    @Autowired
    CompanyShopService companyShopService;
    @Autowired
    CompanyService companyService;
    @Autowired
    SeoRegionService seoRegionService;

    @Autowired
    @Qualifier("appStringRedisTemplate")
    StringRedisTemplate appRedis;

    /**
     * master
     * @param shopId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/detail/{shopId}")
    public BaseBizResult<Map<String, Object>> queryDetail(@PathVariable(value = "shopId", required = true) Long shopId,
                                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            ShopDetail shopDetail = shopService.getShopDetailById(shopId);
            map.put("shopdetail", shopDetail);


            String regionPath = "";
            String regionPathName = "";
            if (shopDetail != null){
                if (!StringUtils.isEmpty(shopDetail.getShopRegion())) {
                    regionPath = shopDetail.getShopRegion().replace("_", ",");
                    String[] regionArray = regionPath.split(",");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < regionArray.length; i++) {
                        SeoRegion seoRegion = seoRegionService.getSeoRegionByRegionCode(regionArray[i]);
                        if (i != regionArray.length - 1) {
                            stringBuilder.append(seoRegion.getRegionName()).append(",");
                        } else {
                            stringBuilder.append(seoRegion.getRegionName());
                        }
                    }
                    regionPathName = stringBuilder.toString();
                }
            }

            map.put("regionPath", regionPath);
            map.put("regionPathName", regionPathName);

            // 获取店铺对应的公司id列表，由于店铺和公司是 n:1 关系，所以该列表的长度最大为1，取第一个元素就可以了，若没有公司则公司为为空
            List<CompanyShop> companyShopList = companyShopService.getCompanyShopListByShopId(shopId, DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE);
            if (companyShopList != null && companyShopList.size() >= 1) {
                CompanyBrief companyBrief = companyService.getCompanyBriefById(companyShopList.get(0).getCompanyId());
                map.put("companyBrief", companyBrief);
            } else {
                map.put("companyBrief", null);
            }

            // 评论列表
            List<CommentDetail> commentDetailList = commentService.getCommentListByShopId(shopId, COMMENT_TYPE_ALL, pageNum, pageSize);
            map.put("list", commentDetailList);
            long count = commentService.countCommentListByShopId(shopId, COMMENT_TYPE_ALL);
            map.put("count", count);

            long picCount = commentService.countCommentListByShopId(shopId, COMMENT_TYPE_PIC);
            long goodCount = commentService.countCommentListByShopId(shopId, COMMENT_TYPE_GOOD);
            long middleCount = commentService.countCommentListByShopId(shopId, COMMENT_TYPE_MIDDLE);
            long badCount = commentService.countCommentListByShopId(shopId, COMMENT_TYPE_BAD);

            map.put("picCount", picCount);
            map.put("goodCount", goodCount);
            map.put("middleCount", middleCount);
            map.put("badCount", badCount);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
        return BaseBizResult.success(map);
    }

    /**
     * 根据 regionPath 获取店铺列表 （包含regionPath的子地区的店铺）
     *
     * @param regionPath 地区code路径 多级时以 "_" 连接，如 北京市密云区 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/list/{regionPath}")
    public BaseBizResult<Map<String, Object>> getShopList(@PathVariable(value = "regionPath", required = true) String regionPath,
                                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
                List<ShopDetail> shopDetailList = shopService.getShopListByRegion(regionPath, pageNum, pageSize);
                long count = shopService.countShopListbyRegion(regionPath);
                map.put("list", shopDetailList);
                map.put("count", count);
                return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
    }


    /**
     * 根据 regionPath 推荐店铺列表
     *
     * @param regionPath 地区code路径 多级时以 "_" 连接，如 北京市密云区 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/recommendlist")
    public BaseBizResult<Map<String, Object>> getRecommendShopList(@RequestParam(name = "regionPath", required = false) String regionPath,
                                                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                   HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isEmpty(regionPath)) {
                regionPath = (String) request.getAttribute("regionCode");
            }
            PageInfo pageInfo = shopService.getRecommentShopBriefListByRegion(regionPath, 0, pageNum, pageSize);
            map.put("list", pageInfo.getList());
            map.put("count", pageInfo.getTotal());
            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * 根据 regionPath 推荐当月点击数TopN店铺列表
     *
     * @param regionPath 地区code路径 多级时以 "_" 连接，如 北京市密云区 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/hotclick")
    public BaseBizResult<Map<String, Object>> hotClickShopList(@RequestParam(name = "regionPath", required = true) String regionPath,
                                                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                               HttpServletRequest request) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (StringUtils.isEmpty(regionPath)) {
                regionPath = (String) request.getAttribute("regionCode");
            }

            Integer from = (pageNum - 1)* pageSize;
            Integer end = pageNum * pageSize - 1;
            LocalDate localDate = LocalDate.now();
            // 每个月
            String hot_click_key = SHOP_HOT_CLICK_PREFIX + ":" + localDate.getYear()+":"+localDate.getMonthValue() + ":" + regionPath.replace("_", ":");
            long count = appRedis.opsForZSet().zCard(hot_click_key);
            Set<ZSetOperations.TypedTuple<String>> shopIdSet = appRedis.opsForZSet().reverseRangeWithScores(hot_click_key, from, end);
            Iterator<ZSetOperations.TypedTuple<String>> iterator = shopIdSet.iterator();
            List shopBriefList = new LinkedList<>();
            while (iterator.hasNext()){
                try {
                    ZSetOperations.TypedTuple<String> next = iterator.next();
                    String idStr = String.valueOf(next.getValue());
                    ShopBrief shopBrief = shopService.getShopBriefById(Long.valueOf(idStr));
                    if (shopBrief != null){
                        shopBriefList.add(shopBrief);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            map.put("list", shopBriefList);
            map.put("count", count);
            return BaseBizResult.success(map);
        } catch (Exception e) {
            return BaseBizResult.error(e.getMessage());
        }
    }

}
