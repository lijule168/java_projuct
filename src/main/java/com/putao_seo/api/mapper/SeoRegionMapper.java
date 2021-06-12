package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.SeoRegion;
import com.putao_seo.api.entity.SeoRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeoRegionMapper {
    long countByExample(SeoRegionExample example);

    int deleteByExample(SeoRegionExample example);

    int deleteByPrimaryKey(String regionCode);

    int insert(SeoRegion record);

    int insertSelective(SeoRegion record);

    List<SeoRegion> selectByExample(SeoRegionExample example);

    SeoRegion selectByPrimaryKey(String regionCode);

    int updateByExampleSelective(@Param("record") SeoRegion record, @Param("example") SeoRegionExample example);

    int updateByExample(@Param("record") SeoRegion record, @Param("example") SeoRegionExample example);

    int updateByPrimaryKeySelective(SeoRegion record);

    int updateByPrimaryKey(SeoRegion record);
}