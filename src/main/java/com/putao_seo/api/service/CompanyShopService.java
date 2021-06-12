package com.putao_seo.api.service;

import com.putao_seo.api.entity.CompanyShop;
import com.putao_seo.api.entity.ShopBrief;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author : tangtonglong
 * 2019/5/17 11:40
 * @return
 */
public interface CompanyShopService {

    /**
     * 根据公司id获取该公司下的店铺简介列表
     * @param companyId 公司id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "CompanyShop",keyGenerator = "keyGenerator")
    List<ShopBrief> getShopBriefListByCompanyId(Long companyId, Integer pageNum, Integer pageSize);

    /**
     * 根据公司ID 获取该公司下的店铺的数量
     * @param companyId 公司id
     * @return
     */
    @Cacheable(value = "CompanyShop",keyGenerator = "keyGenerator")
    long countShopBriefListByCompanyId(Long companyId);

    /**
     * 根据店铺id 获取该店铺所属的公司
     * @param shopId 店铺id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Cacheable(value = "CompanyShop",keyGenerator = "keyGenerator")
    List<CompanyShop> getCompanyShopListByShopId(Long shopId, Integer pageNum, Integer pageSize);

    /**
     * 根据店铺id 获取该店铺所属的公司的数量
     * @param shopId 店铺id
     * @return
     */
    @Cacheable(value = "CompanyShop",keyGenerator = "keyGenerator")
    long countCompanyShopListByShopId(Long shopId);
}
