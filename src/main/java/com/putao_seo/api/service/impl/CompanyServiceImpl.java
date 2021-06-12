package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.*;
import com.putao_seo.api.mapper.CommentDetailMapper;
import com.putao_seo.api.mapper.CompanyDetailMapper;
import com.putao_seo.api.mapper.CompanyShopMapper;
import com.putao_seo.api.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

import static com.putao_seo.api.constants.CommonConstants.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyDetailMapper companyDetailMapper;

    @Resource
    CompanyShopMapper companyShopMapper;

    @Resource
    CommentDetailMapper commentDetailMapper;

    @Override
    public CompanyDetail getCompanyDetailById(Long companyId) {

        return companyDetailMapper.selectByPrimaryKey(companyId);
    }

    /**
     * 根据公司ID获取公司简介
     *
     * @param companyId 公司ID
     * @return
     */
    @Override
    public CompanyBrief getCompanyBriefById(Long companyId) {
        return companyDetailMapper.selectBriefByPrimaryKey(companyId);
    }

    /**
     * 根据地区code路径 获取该路径下的公司列表
     *
     * @param regionPath   地区code路径 多级时以 "_" 连接，如 北京市密云区 是 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param includeChild 是否包含regionPath 的子地区的 公司 true: 包含 ; false : 不包含
     * @param pageNum      页码
     * @param pageSize     页大小
     * @return
     */
    @Override
    public List<CompanyBrief> getCompanyBriefListByRegionPath(String regionPath, boolean includeChild, Integer pageNum, Integer pageSize) {
        //公司限制只能取前10页，每页10条，故 pageNum*pageSize必须 小于等于 100
        if (pageNum * pageSize > 100){
            pageNum = 10;
            pageSize = 10;
        }
        int offset = (pageNum - 1)*pageSize;

        CompanyDetailExample companyDetailExample = new CompanyDetailExample();
        if (includeChild){
            companyDetailExample.createCriteria().andCompanyRegionLike(regionPath + "%");
        }else {
            companyDetailExample.createCriteria().andCompanyRegionEqualTo(regionPath);
        }

        companyDetailExample.setOffset(offset);
        companyDetailExample.setPageSize(pageSize);
        companyDetailExample.setOrderByClause("company_star desc");
        return companyDetailMapper.selectBriefByExample(companyDetailExample);
    }

    /**
     * 根据地区code路径 获取该路径下的公司数量
     *
     * @param regionPath   地区code路径 多级时以 "_" 连接，如 北京市密云区 是 "2_c434" (北京的regionCode是 2， 密云区是 c434）
     * @param includeChild 是否包含regionPath 的子地区的 公司 true: 包含 ; false : 不包含
     * @return
     */
    @Override
    public long countCompanyListByRegionPath(String regionPath, boolean includeChild) {

        CompanyDetailExample companyDetailExample = new CompanyDetailExample();
        if (includeChild){
            companyDetailExample.createCriteria().andCompanyRegionLike(regionPath + "%");
        }else {
            companyDetailExample.createCriteria().andCompanyRegionEqualTo(regionPath);
        }

        return companyDetailMapper.countByExample(companyDetailExample);
    }



}
