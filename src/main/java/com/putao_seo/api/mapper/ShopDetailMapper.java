package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.ShopBrief;
import com.putao_seo.api.entity.ShopDetail;
import com.putao_seo.api.entity.ShopDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


public interface ShopDetailMapper {
    long countByExample(ShopDetailExample example);

    int deleteByExample(ShopDetailExample example);

    int deleteByPrimaryKey(Long shopId);

    int insert(ShopDetail record);

    int insertSelective(ShopDetail record);

    List<ShopDetail> selectByExample(ShopDetailExample example);

    ShopDetail selectByPrimaryKey(Long shopId);

    List<ShopBrief> selectBriefByExample(ShopDetailExample example);

    ShopBrief selectBriefByPrimaryKey(Long shopId);

    int updateByExampleSelective(@Param("record") ShopDetail record, @Param("example") ShopDetailExample example);

    int updateByExample(@Param("record") ShopDetail record, @Param("example") ShopDetailExample example);

    int updateByPrimaryKeySelective(ShopDetail record);

    int updateByPrimaryKey(ShopDetail record);

    List<ShopBrief> getRecommentShopBriefListByRegion(@Param("regionPath") String regionPath, @Param("minCommentCount")Integer minCommentCount, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    long countRecommentShopBriefListByRegion(@Param("regionPath") String regionPath, @Param("minCommentCount") Integer minCommentCount);

}