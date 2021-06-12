package com.putao_seo.api.controller;

import com.putao_seo.api.entity.SeoRegion;
import com.putao_seo.api.service.SeoRegionService;
import com.putao_seo.api.utils.BaseBizResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author : tangtonglong
 * 2019/5/16 16:06
 * @return
 */

@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(path = "/seoregion", produces = {"application/json;charset=UTF-8"})
public class SeoRegionController {

    private static Logger logger = LoggerFactory.getLogger(SeoRegionController.class);
    @Autowired
    SeoRegionService seoRegionService;


    /**
     * 根据地区Code获取下面的 地点子列表(包含孙子，重孙子地区)
     * regionCode 非必输，不传时根据ip得到城市的regionCode， 当ip转换错误时使用 北京市 的地区代码
     * @param regionCode 地区Code
     * @param request
     * @return
     */
    @GetMapping(value = "/sublist")
    public BaseBizResult<Map<String,Object>> querySubRegionList(@RequestParam(value = "regionCode",required = false)String regionCode,
                                                      @RequestParam(value = "includeGrandChild",required = false,defaultValue = "false")boolean includeGrandChild,
                                                      HttpServletRequest request) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (StringUtils.isEmpty(regionCode)){
                regionCode = (String)request.getAttribute("regionCode");
            }
//            List<Object> regionList = new LinkedList<>();
//            SeoRegion seoReigon = seoRegionService.getSeoRegionByRegionCode(regionCode);
//            String[] parentArray = seoReigon.getPidPath().split("_");
//            List<String> parentList = new LinkedList<>(Arrays.asList(parentArray));
//            Map<String,Object> regionMap = new HashMap<>();

            // 默认不包含孙子，重孙子地区
            List<SeoRegion> seoRegionList = seoRegionService.getSubRegionList(regionCode,includeGrandChild);
            map.put("subRegionList",seoRegionList);

            SeoRegion currentSeoRegion = seoRegionService.getSeoRegionByRegionCode(regionCode);
            if (currentSeoRegion != null){
                map.put("currentCity",currentSeoRegion.getRegionName());
            }else {
                map.put("currentCity","");
            }

            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }

    }

    @GetMapping(value = "/list")
    public BaseBizResult<List<SeoRegion>> queryRegionList(@RequestParam(value = "regionCode",required = false)String regionCode,
                                                      HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtils.isEmpty(regionCode)){
                regionCode = (String)request.getAttribute("regionCode");
            }

            List<SeoRegion> seoRegionList = seoRegionService.getRegionList(regionCode);
            return BaseBizResult.success(seoRegionList);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }

    }

    /**
     * 根据 regionCode 获取该地区的地区路径
     * eg ： regionCode 为 r5950 昌平
     * 返回为： regionPath 2_r5950
     *         regionPathName 北京市_昌平区
     *         subList [r23044,.....]
     * @param regionCode 地区代码
     * @param includeSubRegion 包含regionCode 的子地区 true ：包含 ； false ： 不包含
     * @param request
     * @return
     */
    @GetMapping(value = "/path")
    public BaseBizResult<Map<String,Object>> queryRegionPath(@RequestParam(value = "regionCode",required = false)String regionCode,
                                                          @RequestParam(value = "includeSubRegion",required = false,defaultValue = "false")boolean includeSubRegion,
                                                          HttpServletRequest request) {

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (StringUtils.isEmpty(regionCode)){
                regionCode = (String)request.getAttribute("regionCode");
            }

            SeoRegion currentSeoRegion = seoRegionService.getSeoRegionByRegionCode(regionCode);
            String regionPath = StringUtils.isEmpty(currentSeoRegion.getPid())? regionCode:currentSeoRegion.getPidPath()+"_"+regionCode;
            map.put("regionPath", regionPath);

            String[] pathArray = regionPath.split("_");
            StringBuilder regionPathNameBuilder = new StringBuilder();
            for (int i = 0;i<pathArray.length;i++){
                SeoRegion ele = seoRegionService.getSeoRegionByRegionCode(pathArray[i]);
                if (i == pathArray.length-1){
                    regionPathNameBuilder.append(ele.getRegionName());
                }else {
                    regionPathNameBuilder.append(ele.getRegionName()).append("_");
                }

            }
            map.put("regionPathName", regionPathNameBuilder.toString());

            if (includeSubRegion){
                List<SeoRegion> subRegionList = seoRegionService.getSubRegionList(regionCode,false);
                map.put("subRegionList", subRegionList);
            }

            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseBizResult.error(e.getMessage());
        }

    }
}
