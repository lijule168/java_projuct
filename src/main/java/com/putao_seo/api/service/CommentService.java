package com.putao_seo.api.service;

import com.putao_seo.api.entity.CommentDetail;
import io.swagger.models.auth.In;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;



public interface CommentService {

    /**
     * 根据shopid 获取该店铺的评论列表
     * @param shopId
     * @return
     */
    @Cacheable(value = "Comment",keyGenerator = "keyGenerator")
    List<CommentDetail> getCommentListByShopId(Long shopId, String queryType, Integer pageNum,Integer pageSize);

    /**
     * 根据shopid 获取该店铺的评论数
     * @param shopId
     * @return
     */
    @Cacheable(value = "Comment",keyGenerator = "keyGenerator")
    long countCommentListByShopId(Long shopId, String queryType);

    /**
     * 根据公司id 获取公司的评论（其实是公司下的店铺的评论）
     * @param companyId 公司ID
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @Cacheable(value = "Comment",keyGenerator = "keyGenerator")
    List<CommentDetail> getCompanyCommentByCompanyId(Long companyId, String queryType, Integer pageNum,Integer pageSize);

    /**
     * 根据公司id 获取公司的评论（其实是公司下的店铺的评论）
     * @param companyId 公司ID
     * @return
     */
    @Cacheable(value = "Comment",keyGenerator = "keyGenerator")
    long countCompanyCommentByCompanyId(Long companyId, String queryType);


    /**
     *  获取优质评论，
     *  TODO 优质的定义？？？？
     * @param ShopId
     * @param companyId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Cacheable(value = "Comment",keyGenerator = "keyGenerator")
    List<CommentDetail> getHighQualityComment(Integer ShopId, Integer companyId, Integer pageNum, Integer pageSize);
}
