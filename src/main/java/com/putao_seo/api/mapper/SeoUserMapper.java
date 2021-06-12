package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.SeoUser;
import com.putao_seo.api.entity.SeoUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeoUserMapper {
    long countByExample(SeoUserExample example);

    int deleteByExample(SeoUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SeoUser record);

    int insertSelective(SeoUser record);

    List<SeoUser> selectByExample(SeoUserExample example);

    SeoUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SeoUser record, @Param("example") SeoUserExample example);

    int updateByExample(@Param("record") SeoUser record, @Param("example") SeoUserExample example);

    int updateByPrimaryKeySelective(SeoUser record);

    int updateByPrimaryKey(SeoUser record);
}