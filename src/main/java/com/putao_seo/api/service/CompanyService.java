package com.putao_seo.api.service;

import com.putao_seo.api.entity.CommentDetail;
import com.putao_seo.api.entity.CompanyBrief;
import com.putao_seo.api.entity.CompanyDetail;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface CompanyService {


    /**
     * 根据公司ID获取公司详情
     * @param companyId 公司ID
     * @return
     */
    @Cacheable(value = "Company",keyGenerator = "keyGenerator")
    CompanyDetail getCompanyDetailById(Long companyId);

    /**
     * 根据公司ID获取公司简介
     * @param companyId 公司ID
     * @return
     */
    @Cacheable(value = "Company",keyGenerator = "keyGenerator")
    CompanyBrief getCompanyBriefById(Long companyId);

    /**
     * 根据地区code路径 获取该路径下的公司简介列表
     * @param regionPath 地区code路径 多级时以 "_" 连接，如 北京市密云区 是 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param includeChild 是否包含regionPath 的子地区的 公司 true: 包含 ; false : 不包含
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Company",keyGenerator = "keyGenerator")
    List<CompanyBrief> getCompanyBriefListByRegionPath(String regionPath, boolean includeChild, Integer pageNum, Integer pageSize);

    /**
     * 根据地区code路径 获取该路径下的公司数量
     * @param regionPath 地区code路径 多级时以 "_" 连接，如 北京市密云区 是 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param includeChild 是否包含regionPath 的子地区的 公司 true: 包含 ; false : 不包含
     * @return
     */
    @Cacheable(value = "Company",keyGenerator = "keyGenerator")
    long countCompanyListByRegionPath(String regionPath, boolean includeChild);


}
