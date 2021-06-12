package com.putao_seo.api.service;

import com.putao_seo.api.entity.Article;
import com.putao_seo.api.entity.ArticleBrief;
import com.putao_seo.api.entity.EsArticle;
import io.swagger.models.auth.In;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;


public interface ArticleService {

    /**
     * 获取分类id为 categoryId 的文章列表
     * @param categoryId 分类id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<Article> getArticleListByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize);

    /**
     * 获取分类id为 categoryId 的文章数量
     * @param categoryId 分类id
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    long countArticleListByCategoryId(Integer categoryId);

    /**
     * 获取分类id在 categoryIdList 中的文章列表
     * @param categoryIdList 分类id列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<ArticleBrief> getArticleBriefListByCategoryIdList(List<Integer> categoryIdList, Integer pageNum, Integer pageSize);

    /**
     * 获取 符合 id为 articleId ，分类为 categoryId 的 下一篇（上一篇）文章列表
     * @param categoryId 分类id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<ArticleBrief> getNextArticleBriefListByCategoryId(Integer articleId, Integer categoryId, Integer pageNum, Integer pageSize);

    /**
     * 获取 符合 id为 articleId ，分类为 categoryId 的 上一篇 文章列表
     * @param categoryId 分类id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<ArticleBrief> getPriorArticleBriefListByCategoryId(Integer articleId, Integer categoryId, Integer pageNum, Integer pageSize);


    /**
     * 获取分类id在 categoryIdList 中的文章数量
     * @param categoryIdList 分类id列表
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    long countArticleListByCategoryIdList(List<Integer> categoryIdList);

    /**
     * 根据文章id获取 文章详情
     * @param articleId 文章id
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    Article getArticleById(Integer articleId);

    /**
     * 根据文章id获取 文章简介
     * @param articleId 文章id
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    ArticleBrief getArticleBriefById(Integer articleId);

    /**
     * 获取推荐文章列表
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<ArticleBrief> getRecommendArticleBriefList();

    /**
     * 根据分类名获取文章列表
     * @param categoryName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    List<ArticleBrief> getArticleBriefListByCategoryName(String categoryName, Integer pageNum, Integer pageSize);

    /**
     * 根据分类名获取文章列表
     * @param categoryName
     * @return
     */
    @Cacheable(value = "Article",keyGenerator = "keyGenerator")
    long countArticleBriefListByCategoryName(String categoryName);

    /**
     *
     * @param title
     * @param pageNum
     * @param pageSize
     * @return
     */
//    List<EsArticle> getArticleBriefFromElasticsearchByTitle(String title, Integer pageNum, Integer pageSize);
//
//
//    public Map<String, Object> search(Class classType, String title, Integer pageNum, Integer pageSize);
}
