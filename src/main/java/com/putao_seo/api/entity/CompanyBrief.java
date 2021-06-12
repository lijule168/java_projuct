package com.putao_seo.api.entity;

import java.io.Serializable;

/**
 * @author : tangtonglong
 * 2019/5/17 13:41
 * @return
 */
public class CompanyBrief implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long companyId;

    private String companyName;

    private String companyImg;

    private String companyTel;

    private String companyAddress;

    private String companyTelEmailAddress;



    private String companyLatlng;

    private String companyRegion;

    private String companyStar;

    private String companyTag;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyImg() {
        return companyImg;
    }

    public void setCompanyImg(String companyImg) {
        this.companyImg = companyImg;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyTelEmailAddress() {
        return companyTelEmailAddress;
    }

    public void setCompanyTelEmailAddress(String companyTelEmailAddress) {
        this.companyTelEmailAddress = companyTelEmailAddress;
    }


    public String getCompanyLatlng() {
        return companyLatlng;
    }

    public void setCompanyLatlng(String companyLatlng) {
        this.companyLatlng = companyLatlng;
    }

    public String getCompanyRegion() {
        return companyRegion;
    }

    public void setCompanyRegion(String companyRegion) {
        this.companyRegion = companyRegion;
    }

    public String getCompanyStar() {
        return companyStar;
    }

    public void setCompanyStar(String companyStar) {
        this.companyStar = companyStar;
    }

    public String getCompanyTag() {
        return companyTag;
    }

    public void setCompanyTag(String companyTag) {
        this.companyTag = companyTag;
    }
}
