package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyShopMapper {
    long countByExample(CompanyShopExample example);

    int deleteByExample(CompanyShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyShop record);

    int insertSelective(CompanyShop record);

    List<CompanyShop> selectByExample(CompanyShopExample example);

    CompanyShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyShop record, @Param("example") CompanyShopExample example);

    int updateByExample(@Param("record") CompanyShop record, @Param("example") CompanyShopExample example);

    int updateByPrimaryKeySelective(CompanyShop record);

    int updateByPrimaryKey(CompanyShop record);

    /**
     * 根据公司id获取该公司下的店铺简介列表
     * @return
     */
    List<ShopBrief> selectShopBriefListByCompanyId(@Param("companyShop") CompanyShop companyShop,
                                                   @Param("shopDetail") ShopDetail shopDetail,
                                                   @Param("offset") Integer offset,@Param("pageSize") Integer pageSize);

    /**
     * 根据公司ID 获取该公司下的店铺的数量
     * @return
     */
    long countShopBriefListByCompanyId(@Param("companyShop") CompanyShop companyShop, @Param("shopDetail") ShopDetail shopDetail);
}