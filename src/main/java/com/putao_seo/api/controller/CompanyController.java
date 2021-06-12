package com.putao_seo.api.controller;

import com.putao_seo.api.entity.CompanyBrief;
import com.putao_seo.api.entity.CompanyDetail;
import com.putao_seo.api.entity.ShopBrief;
import com.putao_seo.api.service.CommentService;
import com.putao_seo.api.service.CompanyService;
import com.putao_seo.api.service.CompanyShopService;
import com.putao_seo.api.utils.BaseBizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.COMMENT_TYPE_ALL;

/**
 * @author : tangtonglong
 * 2019/5/17 10:54
 * @return
 */
@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(path = "/company", produces = {"application/json;charset=UTF-8"})
public class CompanyController {

    @Autowired
    CompanyShopService companyShopService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CommentService commentService;

    /**
     * 根据公司id获取公司详情和公司下的店铺简介列表
     * @param companyId 公司id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @GetMapping(value = "/detail/{companyId}")
    public BaseBizResult<Map<String, Object>> queryDetail(@PathVariable(value = "companyId",required = true)Long companyId,
                                                          @RequestParam(name = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                                          @RequestParam(name = "pageSize", required = false, defaultValue = "10")Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        //TODO 店铺页码页大小，评论页码，页大小
            //公司详情
            CompanyDetail companyDetail = companyService.getCompanyDetailById(companyId);
            if (companyDetail != null){
                // 数据库中的公司详情没有公司评论数
                long commentCount = commentService.countCompanyCommentByCompanyId(companyId,COMMENT_TYPE_ALL);
                companyDetail.setCompanyCommentCount(commentCount);
            }

            map.put("detail", companyDetail);
            // 该公司下的店铺简介列表
            List<ShopBrief> shopBriefList = companyShopService.getShopBriefListByCompanyId(companyId,pageNum,pageSize);
            long shopBriefCount = companyShopService.countShopBriefListByCompanyId(companyId);
            map.put("list", shopBriefList);
            map.put("count", shopBriefCount);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
        return BaseBizResult.success(map);
    }

    /**
     * 根据regionPath获取公司简介列表
     * @param regionPath 地区code路径
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @GetMapping(value = "/list")
    public BaseBizResult<Map<String, Object>> getCompanyListByRegionPath(@RequestParam(value = "regionPath",required = false)String regionPath,
                                                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10")Integer pageSize,
                                                                         HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            if (StringUtils.isEmpty(regionPath)){
                regionPath = (String)request.getAttribute("regionCode");
            }
            //公司简介列表
            List<CompanyBrief> companyBriefList = companyService.getCompanyBriefListByRegionPath(regionPath,true,pageNum,pageSize);

            long count = companyService.countCompanyListByRegionPath(regionPath,true);

            map.put("list", companyBriefList);
            map.put("count", count);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }
        return BaseBizResult.success(map);
    }
}
