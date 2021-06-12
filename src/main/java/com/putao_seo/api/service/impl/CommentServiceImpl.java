package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.CommentDetail;
import com.putao_seo.api.entity.CommentDetailExample;
import com.putao_seo.api.entity.CompanyShop;
import com.putao_seo.api.entity.CompanyShopExample;
import com.putao_seo.api.mapper.CommentDetailMapper;
import com.putao_seo.api.mapper.CompanyShopMapper;
import com.putao_seo.api.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

import static com.putao_seo.api.constants.CommonConstants.*;
import static com.putao_seo.api.constants.CommonConstants.COMMENT_MIDDLE_STAR;
import static com.putao_seo.api.constants.CommonConstants.COMMENT_TYPE_BAD;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentDetailMapper commentDetailMapper;

    @Resource
    CompanyShopMapper companyShopMapper;

    @Override
    public List<CommentDetail> getCommentListByShopId(Long shopId, String queryType, Integer pageNum,Integer pageSize) {
        //评论限制只能取前三页，每页10条，故 pageNum*pageSize必须 小于等于 30
        if (pageNum * pageSize > 30){
            pageNum = 3;
            pageSize = 10;
        }
        int offset = (pageNum-1)*pageSize;
        CommentDetailExample commentDetailExample = new CommentDetailExample();
        commentDetailExample.setOffset(offset);
        commentDetailExample.setPageSize(pageSize);
        commentDetailExample.createCriteria().andShopIdEqualTo(shopId);
        if (queryType.equals(COMMENT_TYPE_ALL)){

        }else if (queryType.equals(COMMENT_TYPE_PIC)){
            commentDetailExample.getOredCriteria().get(0).andCommentImgsIsNotNull().andCommentImgsLengthGreaterThan(2);
        }else if(queryType.equals(COMMENT_TYPE_GOOD)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarGreaterThanOrEqualTo(COMMENT_GOOD_STAR);
        }else if (queryType.equals(COMMENT_TYPE_MIDDLE)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarLessThan(COMMENT_GOOD_STAR).andCommentStarGreaterThan(COMMENT_MIDDLE_STAR);
        }else if (queryType.equals(COMMENT_TYPE_BAD)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarLessThanOrEqualTo(COMMENT_MIDDLE_STAR);
        }
        commentDetailExample.setOrderByClause("comment_time desc");
        List<CommentDetail> commentDetailList = commentDetailMapper.selectByExample(commentDetailExample);
        return commentDetailList;
    }

    @Override
    public long countCommentListByShopId(Long shopId, String queryType) {
        CommentDetailExample commentDetailExample = new CommentDetailExample();
        commentDetailExample.createCriteria().andShopIdEqualTo(shopId);
        if (queryType.equals(COMMENT_TYPE_ALL)){

        }else if (queryType.equals(COMMENT_TYPE_PIC)){
            commentDetailExample.getOredCriteria().get(0).andCommentImgsIsNotNull().andCommentImgsLengthGreaterThan(2);
        }else if(queryType.equals(COMMENT_TYPE_GOOD)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarGreaterThanOrEqualTo(COMMENT_GOOD_STAR);
        }else if (queryType.equals(COMMENT_TYPE_MIDDLE)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarLessThan(COMMENT_GOOD_STAR).andCommentStarGreaterThan(COMMENT_MIDDLE_STAR);
        }else if (queryType.equals(COMMENT_TYPE_BAD)){
            commentDetailExample.getOredCriteria().get(0).andCommentStarLessThanOrEqualTo(COMMENT_MIDDLE_STAR);
        }
        return commentDetailMapper.countByExample(commentDetailExample);
    }

    /**
     * 根据公司id 获取公司的评论（其实是公司下的店铺的评论）
     *
     * @param companyId 公司ID
     * @param pageNum   页码
     * @param pageSize  页大小
     * @return
     */
    @Override
    public List<CommentDetail> getCompanyCommentByCompanyId(Long companyId, String queryType, Integer pageNum, Integer pageSize) {
        //评论限制只能取前三页，每页10条，故 pageNum*pageSize必须 小于等于 30
        if (pageNum * pageSize > 30){
            pageNum = 3;
            pageSize = 10;
        }
        CompanyShopExample companyShopExample = new CompanyShopExample();
        companyShopExample.createCriteria().andCompanyIdEqualTo(companyId);
        List<CompanyShop> companyShopList = companyShopMapper.selectByExample(companyShopExample);
        if (companyShopList != null && companyShopList.size() > 0){
            List<Long> shopIdLIst = new LinkedList<>();
            for (CompanyShop ele: companyShopList){
                shopIdLIst.add(ele.getShopId());
            }
            int offset = (pageNum -1 )*pageSize;
            CommentDetailExample commentDetailExample = new CommentDetailExample();
            commentDetailExample.createCriteria().andShopIdIn(shopIdLIst);
            if (queryType.equals(COMMENT_TYPE_ALL)){

            }else if (queryType.equals(COMMENT_TYPE_PIC)){
                commentDetailExample.getOredCriteria().get(0).andCommentImgsIsNotNull().andCommentImgsLengthGreaterThan(2);
            }else if(queryType.equals(COMMENT_TYPE_GOOD)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarGreaterThanOrEqualTo(COMMENT_GOOD_STAR);
            }else if (queryType.equals(COMMENT_TYPE_MIDDLE)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarLessThan(COMMENT_GOOD_STAR).andCommentStarGreaterThan(COMMENT_MIDDLE_STAR);
            }else if (queryType.equals(COMMENT_TYPE_BAD)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarLessThanOrEqualTo(COMMENT_MIDDLE_STAR);
            }

            commentDetailExample.setOrderByClause("comment_time desc");

            commentDetailExample.setOffset(offset);
            commentDetailExample.setPageSize(pageSize);

            return commentDetailMapper.selectByExample(commentDetailExample);
        }else {
            return null;
        }

    }

    /**
     * 根据公司id 获取公司的评论（其实是公司下的店铺的评论）
     *
     * @param companyId 公司ID
     * @return
     */
    @Override
    public long countCompanyCommentByCompanyId(Long companyId,String queryType) {
        CompanyShopExample companyShopExample = new CompanyShopExample();
        companyShopExample.createCriteria().andCompanyIdEqualTo(companyId);
        List<CompanyShop> companyShopList = companyShopMapper.selectByExample(companyShopExample);
        if (companyShopList != null && companyShopList.size() > 0){
            List<Long> shopIdLIst = new LinkedList<>();
            for (CompanyShop ele: companyShopList){
                shopIdLIst.add(ele.getShopId());
            }
            CommentDetailExample commentDetailExample = new CommentDetailExample();
            commentDetailExample.createCriteria().andShopIdIn(shopIdLIst);
            if (queryType.equals(COMMENT_TYPE_ALL)){

            }else if (queryType.equals(COMMENT_TYPE_PIC)){
                commentDetailExample.getOredCriteria().get(0).andCommentImgsIsNotNull().andCommentImgsLengthGreaterThan(2);
            }else if(queryType.equals(COMMENT_TYPE_GOOD)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarGreaterThanOrEqualTo(COMMENT_GOOD_STAR);
            }else if (queryType.equals(COMMENT_TYPE_MIDDLE)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarLessThan(COMMENT_GOOD_STAR).andCommentStarGreaterThan(COMMENT_MIDDLE_STAR);
            }else if (queryType.equals(COMMENT_TYPE_BAD)){
                commentDetailExample.getOredCriteria().get(0).andCommentStarLessThanOrEqualTo(COMMENT_MIDDLE_STAR);
            }
            return commentDetailMapper.countByExample(commentDetailExample);
        }else {
            return 0;
        }
    }

    /**
     * @param shopId
     * @param companyId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<CommentDetail> getHighQualityComment(Integer shopId, Integer companyId, Integer pageNum, Integer pageSize) {
        //评论限制只能取前三页，每页10条，故 pageNum*pageSize必须 小于等于 30
        if (pageNum * pageSize > 30){
            pageNum = 3;
            pageSize = 10;
        }
        int offset = (pageNum-1)*pageSize;
        CommentDetailExample commentDetailExample = new CommentDetailExample();
        commentDetailExample.setOffset(offset);
        commentDetailExample.setPageSize(pageSize);
        commentDetailExample.createCriteria().andShopIdEqualTo(Long.valueOf(shopId)).andCommentStarGreaterThan(COMMENT_GOOD_STAR);
        return commentDetailMapper.selectByExample(commentDetailExample);
    }
}
