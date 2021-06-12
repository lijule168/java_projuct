package com.putao_seo.api.service;

import com.putao_seo.api.entity.SeoRegion;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author : tangtonglong
 * 2019/5/16 15:05
 * @return
 */
public interface SeoRegionService {

    /**
     * 根据地区code获取子地点列表(包括孙子地区)
     * @param regionCode 地区代码 非必输（不传时根据ip得到城市） 当ip转换错误时使用 北京市 的地区代码
     * @param includeGrandChild regionCode 的孙子地区 true: 包含 ; false : 不包含
     * @return
     */
    @Cacheable(value = "SeoRegion",keyGenerator = "keyGenerator")
    List<SeoRegion> getSubRegionList(String regionCode , boolean includeGrandChild);

    /**
     * 根据regionCode获取 seoRegion
     * @param regionCode 地区编码
     * @return
     */
    @Cacheable(value = "SeoRegion",keyGenerator = "keyGenerator")
    SeoRegion getSeoRegionByRegionCode(String regionCode);

    /**
     * 获取地区路径
     * @param regionCode
     * @return
     */
    @Cacheable(value = "SeoRegion",keyGenerator = "keyGenerator")
    List<SeoRegion> getRegionList(String regionCode);
}
