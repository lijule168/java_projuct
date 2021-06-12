package com.putao_seo.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.putao_seo.api.entity.Category;
import com.putao_seo.api.entity.ShopBrief;
import com.putao_seo.api.entity.ShopDetail;
import com.putao_seo.api.entity.ShopDetailExample;
import com.putao_seo.api.mapper.SeoRegionMapper;
import com.putao_seo.api.mapper.ShopDetailMapper;
import com.putao_seo.api.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    ShopDetailMapper shopDetailMapper;

    @Resource
    SeoRegionMapper seoRegionMapper;

    @Override
    public ShopDetail getShopDetailById(Long shopId) {
        ShopDetail shopDetail = shopDetailMapper.selectByPrimaryKey(shopId);
        return shopDetail;
    }

    /**
     * 根据店铺id获取店铺简介
     *
     * @param shopId 店铺id
     * @return
     */
    @Override
    public ShopBrief getShopBriefById(Long shopId) {

        return shopDetailMapper.selectBriefByPrimaryKey(shopId);
    }

    /**
     * 根据地区code路径获取店铺列表
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     *  regionPath 为 "2" 查询的是 北京市 的店铺列表
     * @param regionPath regionCode路径
     * @return
     */
    @Override
    public List<ShopDetail> getShopListByRegion(String regionPath, Integer pageNum, Integer pageSize) {
        //店铺限制只能取前10页，每页10条，故 pageNum*pageSize必须 小于等于 100
        if (pageNum * pageSize > 100){
            pageNum = 10;
            pageSize = 10;
        }
//        SeoRegion seoReigon = seoRegionMapper.selectByPrimaryKey(regionCode);
//
//        if (seoReigon != null){
//            int offset = (pageNum-1)*pageSize;
//            ShopDetailExample shopDetailExample = new ShopDetailExample();
//            shopDetailExample.setOffset(offset);
//            shopDetailExample.setPageSize(pageSize);
//
//            String pidPathPrefix = StringUtils.isEmpty(seoReigon.getPidPath())? regionCode : seoReigon.getPidPath()+"_"+regionCode;
//            shopDetailExample.createCriteria().andShopRegionLike(pidPathPrefix + "%");
//            return shopDetailMapper.selectByExample(shopDetailExample);
//        }else {
//            return null;
//        }
        int offset = (pageNum-1)*pageSize;
        ShopDetailExample shopDetailExample = new ShopDetailExample();
        shopDetailExample.setOffset(offset);
        shopDetailExample.setPageSize(pageSize);
        shopDetailExample.createCriteria().andShopRegionLike(regionPath+"%").andShopStatusEqualTo(1);
        shopDetailExample.setOrderByClause("shop_star desc");
        return shopDetailMapper.selectByExample(shopDetailExample);
    }

    /**
     * 根据地区code路径获取店铺数量
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     *  regionPath 为 "2" 查询的是 北京市 的店铺数量
     * @param regionPath regionCode路径
     * @return
     */
    @Override
    public long countShopListbyRegion(String regionPath) {

//        SeoRegion seoReigon = seoRegionMapper.selectByPrimaryKey(regionCode);
//
//        if (seoReigon != null){
//            ShopDetailExample shopDetailExample = new ShopDetailExample();
//
//            String pidPathPrefix = StringUtils.isEmpty(seoReigon.getPidPath())? regionCode : seoReigon.getPidPath()+"_"+regionCode;
//            shopDetailExample.createCriteria().andShopRegionLike(pidPathPrefix + "%");
//            return shopDetailMapper.countByExample(shopDetailExample);
//        }else {
//            return 0;
//        }
        ShopDetailExample shopDetailExample = new ShopDetailExample();
        shopDetailExample.createCriteria().andShopRegionLike(regionPath+"%").andShopStatusEqualTo(1);
        return shopDetailMapper.countByExample(shopDetailExample);
    }

    /**
     * @param regionPath
     * @param commentCount
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ShopBrief> getShopBriefListByExample(String regionPath, Integer commentCount, Integer pageNum, Integer pageSize) {
        //店铺限制只能取前10页，每页10条，故 pageNum*pageSize必须 小于等于 100
        if (pageNum * pageSize > 100){
            pageNum = 10;
            pageSize = 10;
        }
        int offset = (pageNum-1)*pageSize;
        ShopDetailExample shopDetailExample = new ShopDetailExample();
        shopDetailExample.setOffset(offset);
        shopDetailExample.setPageSize(pageSize);
        shopDetailExample.createCriteria().andShopRegionLike(regionPath+"%").andShopStatusEqualTo(1).andShopCommentCountGreaterThanOrEqualTo(String.valueOf(commentCount));
        shopDetailExample.setOrderByClause("shop_star desc");
        return shopDetailMapper.selectBriefByExample(shopDetailExample);
    }

    /**
     * @param regionPath
     * @param commentCount
     * @return
     */
    @Override
    public long countShopBriefListByExample(String regionPath, Integer commentCount) {
        ShopDetailExample shopDetailExample = new ShopDetailExample();
        shopDetailExample.createCriteria().andShopRegionLike(regionPath+"%").andShopStatusEqualTo(1).andShopCommentCountGreaterThanOrEqualTo(String.valueOf(commentCount));
        return shopDetailMapper.countByExample(shopDetailExample);
    }

    /**
     * 根据地区code路径获取推荐店铺
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     * regionPath 为 "2" 查询的是 北京市 的店铺列表
     *
     * @param regionPath
     * @param commentCount
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getRecommentShopBriefListByRegion(String regionPath, Integer commentCount, Integer pageNum, Integer pageSize) {
        //店铺限制只能取前10页，每页10条，故 pageNum*pageSize必须 小于等于 100
        if (pageNum * pageSize > 100){
            pageNum = 10;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum , pageSize);
        List<ShopBrief> shopBriefList = shopDetailMapper.getRecommentShopBriefListByRegion(regionPath, commentCount, pageNum, pageSize);
        //得到分页的结果对象
        PageInfo<ShopBrief> shopBriefPageInfo = new PageInfo<>(shopBriefList);
        return shopBriefPageInfo;
    }

    /**
     * 根据地区code路径获取推荐店铺的数量
     *
     * @param regionPath
     * @param commentCount
     * @return
     */
    @Override
    public long countRecommentShopBriefListByRegion(String regionPath, Integer commentCount) {
        return shopDetailMapper.countRecommentShopBriefListByRegion(regionPath, commentCount);
    }
}
