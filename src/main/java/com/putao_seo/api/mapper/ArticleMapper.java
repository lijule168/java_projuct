package com.putao_seo.api.mapper;

import com.putao_seo.api.entity.Article;
import com.putao_seo.api.entity.ArticleBrief;
import com.putao_seo.api.entity.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer articleid);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer articleid);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<ArticleBrief> selectBriefByExample(ArticleExample example);

    ArticleBrief selectBriefByPrimaryKey(Integer articleid);
}