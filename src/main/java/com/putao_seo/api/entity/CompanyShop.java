package com.putao_seo.api.entity;

import java.io.Serializable;

public class CompanyShop implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Long companyId;

    private Long shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}