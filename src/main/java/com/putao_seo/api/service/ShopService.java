package com.putao_seo.api.service;

import com.github.pagehelper.PageInfo;
import com.putao_seo.api.entity.ShopBrief;
import com.putao_seo.api.entity.ShopDetail;
import io.swagger.models.auth.In;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface ShopService {

    /**
     * 根据店铺id 获取店铺详情
     * @param shopId 店铺id
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    ShopDetail getShopDetailById(Long shopId);

    /**
     * 根据店铺id获取店铺简介
     * @param shopId 店铺id
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    ShopBrief getShopBriefById(Long shopId);

    /**
     * 根据地区code路径获取店铺列表
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     *  regionPath 为 "2" 查询的是 北京市 的店铺列表
     * @param regionPath regionCode路径
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    List<ShopDetail> getShopListByRegion(String regionPath, Integer pageNum, Integer pageSize);

    /**
     * 根据地区code路径获取店铺数量
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     *  regionPath 为 "2" 查询的是 北京市 的店铺数量
     * @param regionPath regionCode路径
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    long countShopListbyRegion(String regionPath);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    List<ShopBrief> getShopBriefListByExample(String regionPath, Integer commentCount, Integer pageNum, Integer pageSize);

    /**
     *
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    long countShopBriefListByExample(String regionPath, Integer commentCount);

    /**
     * 根据地区code路径获取推荐店铺
     * code路径 多级时以 "_" 连接
     * 如 regionPath为 "2_c434" 时查询的时北京市密云区的店铺 (北京的regionCode是 2， 密云区是 c434）
     *  regionPath 为 "2" 查询的是 北京市 的店铺列表
     * @param regionPath
     * @param commentCount
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    PageInfo getRecommentShopBriefListByRegion(String regionPath, Integer commentCount, Integer pageNum, Integer pageSize);

    /**
     * 根据地区code路径获取推荐店铺的数量
     * @param regionPath
     * @param commentCount
     * @return
     */
    @Cacheable(value = "Shop",keyGenerator = "keyGenerator")
    long countRecommentShopBriefListByRegion(String regionPath, Integer commentCount);
}
