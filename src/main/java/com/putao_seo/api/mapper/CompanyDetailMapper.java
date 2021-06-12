package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.CompanyBrief;
import com.putao_seo.api.entity.CompanyDetail;
import com.putao_seo.api.entity.CompanyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyDetailMapper {
    long countByExample(CompanyDetailExample example);

    int deleteByExample(CompanyDetailExample example);

    int deleteByPrimaryKey(Long companyId);

    int insert(CompanyDetail record);

    int insertSelective(CompanyDetail record);

    List<CompanyDetail> selectByExample(CompanyDetailExample example);

    CompanyDetail selectByPrimaryKey(Long companyId);

    List<CompanyBrief> selectBriefByExample(CompanyDetailExample example);

    CompanyBrief selectBriefByPrimaryKey(Long companyId);

    int updateByExampleSelective(@Param("record") CompanyDetail record, @Param("example") CompanyDetailExample example);

    int updateByExample(@Param("record") CompanyDetail record, @Param("example") CompanyDetailExample example);

    int updateByPrimaryKeySelective(CompanyDetail record);

    int updateByPrimaryKey(CompanyDetail record);
}