package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.CommentDetail;
import com.putao_seo.api.entity.CommentDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentDetailMapper {
    long countByExample(CommentDetailExample example);

    int deleteByExample(CommentDetailExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentDetail record);

    int insertSelective(CommentDetail record);

    List<CommentDetail> selectByExample(CommentDetailExample example);

    CommentDetail selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") CommentDetail record, @Param("example") CommentDetailExample example);

    int updateByExample(@Param("record") CommentDetail record, @Param("example") CommentDetailExample example);

    int updateByPrimaryKeySelective(CommentDetail record);

    int updateByPrimaryKey(CommentDetail record);
}