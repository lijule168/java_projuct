package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.SeoRegion;
import com.putao_seo.api.entity.SeoRegionExample;
import com.putao_seo.api.mapper.SeoRegionMapper;
import com.putao_seo.api.service.SeoRegionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.REGION_LEVEL_ONE;

/**
 * @author : tangtonglong
 * 2019/5/16 15:10
 * @return
 */
@Service
public class SeoRegionServiceImpl implements SeoRegionService {

    @Resource
    SeoRegionMapper seoRegionMapper;

    /**
     * 根据地区code获取子地点列表(包括孙子地区)
     *
     * @param regionCode        地区代码 非必输（不传时根据ip得到城市） 当ip转换错误时使用 北京市 的地区代码
     * @param includeGrandChild regionCode 的子地区 true: 包含 ; false : 不包含
     * @return
     */
    @Override
    public List<SeoRegion> getSubRegionList(String regionCode, boolean includeGrandChild) {

        // 确保存在
        SeoRegion seoRegion = seoRegionMapper.selectByPrimaryKey(regionCode);

        if (seoRegion != null) {
            // 是一级地区时，seoRegion的pidPath是空的，此时pidPathPrefix为seoRegion.regionCode
            String pidPathPrefix = StringUtils.isEmpty(seoRegion.getPidPath()) ? regionCode : seoRegion.getPidPath() + "_" + regionCode;
            SeoRegionExample seoRegionExample = new SeoRegionExample();
            if (includeGrandChild) {
                // 包含孙子地区时
                seoRegionExample.createCriteria().andPidPathLike(pidPathPrefix + "%");
            } else {
                // 不包含孙子地区
                seoRegionExample.createCriteria().andPidPathEqualTo(pidPathPrefix);
//                seoRegionExample.createCriteria().andPidEqualTo(regionCode );
            }

            return seoRegionMapper.selectByExample(seoRegionExample);
        } else {
            return null;
        }
    }

    /**
     * 根据regionCode获取 seoRegion
     *
     * @param regionCode 地区编码
     * @return
     */
    @Override
    public SeoRegion getSeoRegionByRegionCode(String regionCode) {
        return seoRegionMapper.selectByPrimaryKey(regionCode);
    }

    /**
     * 获取地区路径
     *
     * @param regionCode 地区编码
     * @return
     */

    @Override
    public List<SeoRegion> getRegionList(String regionCode) {

        SeoRegionExample seoRegionExample = new SeoRegionExample();
        seoRegionExample.createCriteria().andRegionLevelEqualTo(REGION_LEVEL_ONE);
        List<SeoRegion> provinceRegionList = seoRegionMapper.selectByExample(seoRegionExample);

        if (StringUtils.isEmpty(regionCode)){
            return provinceRegionList;
        }

        SeoRegion seoRegion = seoRegionMapper.selectByPrimaryKey(regionCode);

        if (seoRegion != null) {


            seoRegionExample.clear();
            seoRegionExample.createCriteria().andPidEqualTo(regionCode);
            String regionStr = StringUtils.isEmpty(seoRegion.getPidPath())?regionCode:seoRegion.getPidPath()+"_"+regionCode;
            String[] pidArry = regionStr.split("_");


            Map<String, List<SeoRegion>> subRegionMap = new HashMap<>();
            for (String ele :
                    pidArry) {
                subRegionMap.put(ele, getSubRegionList(ele, false));
            }

            List<SeoRegion> parentSeoRegionList = new LinkedList<>();
            for (int i = 0; i < pidArry.length; i++) {
                SeoRegion parentSeoRegion = getSeoRegionByRegionCode(pidArry[i]);
                parentSeoRegion.setSubRegion(subRegionMap.get(pidArry[i]));
                parentSeoRegionList.add(parentSeoRegion);
            }


            if (pidArry.length == 1) {
                int provicePos = -1;
                for (int i = 0; i < provinceRegionList.size(); i++) {
                    if (provinceRegionList.get(i).getRegionCode().equals(pidArry[0])) {
                        provicePos = i;
                        break;
                    }
                }

                if (provicePos >= 0) {
                    provinceRegionList.remove(provicePos);
                    provinceRegionList.add(provicePos, parentSeoRegionList.get(0));
                }
            } else if (pidArry.length == 2) {
                int provicePos = -1;
                for (int i = 0; i < provinceRegionList.size(); i++) {
                    if (provinceRegionList.get(i).getRegionCode().equals(pidArry[0])) {
                        provicePos = i;
                        break;
                    }
                }

                if (provicePos >= 0) {
                    provinceRegionList.remove(provicePos);
                    provinceRegionList.add(provicePos, parentSeoRegionList.get(0));
                }

                int cityPos = -1;
                for (int i = 0; i < provinceRegionList.get(provicePos).getSubRegion().size(); i++) {
                    if (provinceRegionList.get(provicePos).getSubRegion().get(i).getRegionCode().equals(pidArry[1])) {
                        cityPos = i;
                        break;
                    }
                }
                if (cityPos >= 0) {
                    provinceRegionList.get(provicePos).getSubRegion().remove(cityPos);
                    provinceRegionList.get(provicePos).getSubRegion().add(cityPos, parentSeoRegionList.get(1));
                }
            } else if (pidArry.length == 3) {
                int provicePos = -1;
                for (int i = 0; i < provinceRegionList.size(); i++) {
                    if (provinceRegionList.get(i).getRegionCode().equals(pidArry[0])) {
                        provicePos = i;
                        break;
                    }
                }

                if (provicePos >= 0) {
                    provinceRegionList.remove(provicePos);
                    provinceRegionList.add(provicePos, parentSeoRegionList.get(0));
                }

                int cityPos = -1;
                for (int i = 0; i < provinceRegionList.get(provicePos).getSubRegion().size(); i++) {
                    if (provinceRegionList.get(provicePos).getSubRegion().get(i).getRegionCode().equals(pidArry[1])) {
                        cityPos = i;
                        break;
                    }
                }
                if (cityPos >= 0) {
                    provinceRegionList.get(provicePos).getSubRegion().remove(cityPos);
                    provinceRegionList.get(provicePos).getSubRegion().add(cityPos, parentSeoRegionList.get(1));
                }
                int countyPos = -1;
                for (int i = 0; i < provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().size(); i++) {
                    if (provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(i).getRegionCode().equals(pidArry[2])) {
                        countyPos = i;
                        break;
                    }
                }
                if (countyPos >= 0) {
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().remove(countyPos);
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().add(countyPos, parentSeoRegionList.get(2));
                }
            } else if (pidArry.length == 4) {
                // 所在省在列表中的位置
                int provicePos = -1;
                for (int i = 0; i < provinceRegionList.size(); i++) {
                    if (provinceRegionList.get(i).getRegionCode().equals(pidArry[0])) {
                        provicePos = i;
                        break;
                    }
                }

                if (provicePos >= 0) {
                    provinceRegionList.remove(provicePos);
                    provinceRegionList.add(provicePos, parentSeoRegionList.get(0));
                }

                // 所在市在列表中的位置
                int cityPos = -1;
                for (int i = 0; i < provinceRegionList.get(provicePos).getSubRegion().size(); i++) {
                    if (provinceRegionList.get(provicePos).getSubRegion().get(i).getRegionCode().equals(pidArry[1])) {
                        cityPos = i;
                        break;
                    }
                }
                if (cityPos >= 0) {
                    provinceRegionList.get(provicePos).getSubRegion().remove(cityPos);
                    provinceRegionList.get(provicePos).getSubRegion().add(cityPos, parentSeoRegionList.get(1));
                }

                // 所在县在列表中的位置
                int countyPos = -1;
                for (int i = 0; i < provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().size(); i++) {
                    if (provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(i).getRegionCode().equals(pidArry[2])) {
                        countyPos = i;
                        break;
                    }
                }
                if (countyPos >= 0) {
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().remove(countyPos);
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().add(countyPos, parentSeoRegionList.get(2));
                }

                // 所在乡在列表中的位置
                int countryPos = -1;
                for(int i=0;i<provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(countyPos).getSubRegion().size();i++){
                    if (provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(countyPos).getSubRegion().get(i).getRegionCode().equals(pidArry[3])){
                        countryPos = i;
                        break;
                    }
                }
                if (countryPos>=0){
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(countyPos).getSubRegion().remove(countryPos);
                    provinceRegionList.get(provicePos).getSubRegion().get(cityPos).getSubRegion().get(countyPos).getSubRegion().add(countryPos,parentSeoRegionList.get(3));
                }
            }

            return provinceRegionList;

        } else {
            return provinceRegionList;
        }


    }
}
