package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.CompanyShop;
import com.putao_seo.api.entity.CompanyShopExample;
import com.putao_seo.api.entity.ShopBrief;
import com.putao_seo.api.entity.ShopDetail;
import com.putao_seo.api.mapper.CompanyShopMapper;
import com.putao_seo.api.service.CompanyShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : tangtonglong
 * 2019/5/17 11:41
 * @return
 */
@Service
public class CompanyShopServiceImpl implements CompanyShopService {


    @Resource
    CompanyShopMapper companyShopMapper;
    /**
     * 根据公司id获取该公司下的店铺简介列表
     *
     * @param companyId 公司id
     * @param pageNum   页码
     * @param pageSize  页大小
     * @return
     */
    @Override
    public List<ShopBrief> getShopBriefListByCompanyId(Long companyId, Integer pageNum, Integer pageSize) {
        //店铺限制只能取前10页，每页10条，故 pageNum*pageSize必须 小于等于 100
        if (pageNum * pageSize > 100){
            pageNum = 10;
            pageSize = 10;
        }
        CompanyShop companyShop = new CompanyShop();
        companyShop.setCompanyId(companyId);
        int offset = (pageNum - 1)* pageSize;
        ShopDetail shopDetail = new ShopDetail();
        shopDetail.setShopStatus(1);
        return companyShopMapper.selectShopBriefListByCompanyId(companyShop,shopDetail,offset,pageSize);
    }

    /**
     * 根据公司ID 获取该公司下的店铺的数量
     *
     * @param companyId 公司id
     * @return
     */
    @Override
    public long countShopBriefListByCompanyId(Long companyId) {
        CompanyShop companyShop = new CompanyShop();
        companyShop.setCompanyId(companyId);
        ShopDetail shopDetail = new ShopDetail();
        shopDetail.setShopStatus(1);
        return companyShopMapper.countShopBriefListByCompanyId(companyShop,shopDetail);
    }

    /**
     * 根据店铺id 获取该店铺与公司的关联关系
     *
     * @param shopId   店铺id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<CompanyShop> getCompanyShopListByShopId(Long shopId, Integer pageNum, Integer pageSize) {
        CompanyShopExample example = new CompanyShopExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        int offset = (pageNum - 1)*pageSize;
        example.setOffset(offset);
        example.setPageSize(pageSize);
        return companyShopMapper.selectByExample(example);
    }

    /**
     * 根据店铺id 获取该店铺所属的公司的数量
     *
     * @param shopId 店铺id
     * @return
     */
    @Override
    public long countCompanyShopListByShopId(Long shopId) {

        CompanyShopExample companyShopExample = new CompanyShopExample();
        companyShopExample.createCriteria().andShopIdEqualTo(shopId);
        return companyShopMapper.countByExample(companyShopExample);
    }
}
