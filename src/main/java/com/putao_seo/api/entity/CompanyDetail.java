package com.putao_seo.api.entity;

public class CompanyDetail extends CompanyBrief {


    private static final long serialVersionUID = 1L;
    private String companyBusinessInfo;

    private String companyManagedangerous;

    private String companyManagestatus;

    private Integer companyStatus;


    private String companyDesc;

    /**
     * 数据库中无此字段
     * 公司评论的数量
     */
    private Long companyCommentCount;

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyBusinessInfo() {
        return companyBusinessInfo;
    }

    public void setCompanyBusinessInfo(String companyBusinessInfo) {
        this.companyBusinessInfo = companyBusinessInfo;
    }

    public String getCompanyManagedangerous() {
        return companyManagedangerous;
    }

    public void setCompanyManagedangerous(String companyManagedangerous) {
        this.companyManagedangerous = companyManagedangerous;
    }

    public String getCompanyManagestatus() {
        return companyManagestatus;
    }

    public void setCompanyManagestatus(String companyManagestatus) {
        this.companyManagestatus = companyManagestatus;
    }

    public Integer getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Integer companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Long getCompanyCommentCount() {
        return companyCommentCount;
    }

    public void setCompanyCommentCount(Long companyCommentCount) {
        this.companyCommentCount = companyCommentCount;
    }
}