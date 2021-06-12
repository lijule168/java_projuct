package com.putao_seo.api.controller;


import com.putao_seo.api.entity.CommentDetail;
import com.putao_seo.api.service.CommentService;
import com.putao_seo.api.service.CompanyService;
import com.putao_seo.api.utils.BaseBizResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.*;

@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(path = "/comment", produces = {"application/json;charset=UTF-8"})
public class CommentController {

    private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;
    @Autowired
    CompanyService companyService;

    /**
     * 根据店铺ID获取店铺的点评列表
     * @param shopId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list/shop/{shopId}/{pageNum}")
    public BaseBizResult<Map<String, Object>> getCommentListByShopId(@PathVariable("shopId") Long shopId,
                                                                     @PathVariable(value = "pageNum") Integer pageNum,
                                                                     @RequestParam(name = "pageSize", required = false,defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(name = "queryType", required = false,defaultValue = "all")String queryType) {

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<CommentDetail> commentDetailList = commentService.getCommentListByShopId(shopId, queryType, pageNum, pageSize);
            long count = commentService.countCommentListByShopId(shopId, queryType);

            map.put("list", commentDetailList);
            map.put("count", count);

            long picCount = commentService.countCommentListByShopId(shopId,COMMENT_TYPE_PIC);
            long goodCount = commentService.countCommentListByShopId(shopId,COMMENT_TYPE_GOOD);
            long middleCount = commentService.countCommentListByShopId(shopId,COMMENT_TYPE_MIDDLE);
            long badCount = commentService.countCommentListByShopId(shopId,COMMENT_TYPE_BAD);

            map.put("picCount", picCount);
            map.put("goodCount", goodCount);
            map.put("middleCount", middleCount);
            map.put("badCount", badCount);

            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
    }


    /**
     *
     * @param companyId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list/company/{companyId}/{pageNum}")
    public BaseBizResult<Map<String, Object>> getCommentListByCompanyId(@PathVariable("companyId") Long companyId,
                                                                     @PathVariable(value = "pageNum") Integer pageNum,
                                                                     @RequestParam(name = "pageSize", required = false,defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(name = "queryType", required = false,defaultValue = "all")String queryType) {

        Map<String, Object> map = new HashMap<String, Object>();
        try {

            List<CommentDetail> commentDetailList = commentService.getCompanyCommentByCompanyId(companyId,queryType,pageNum,pageSize);
            long commentCount = commentService.countCompanyCommentByCompanyId(companyId,queryType);


            map.put("list", commentDetailList);
            map.put("count", commentCount);

            long picCount = commentService.countCompanyCommentByCompanyId(companyId,COMMENT_TYPE_PIC);
            long goodCount = commentService.countCompanyCommentByCompanyId(companyId,COMMENT_TYPE_GOOD);
            long middleCount = commentService.countCompanyCommentByCompanyId(companyId,COMMENT_TYPE_MIDDLE);
            long badCount = commentService.countCompanyCommentByCompanyId(companyId,COMMENT_TYPE_BAD);

            map.put("picCount", picCount);
            map.put("goodCount", goodCount);
            map.put("middleCount", middleCount);
            map.put("badCount", badCount);

            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
    }
}
