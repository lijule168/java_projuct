package com.putao_seo.api.entity;

public class ShopDetail extends ShopBrief {


    private static final long serialVersionUID = 1L;
    private String shopDesc;

    private String shopBusinessHours;

    private String shopPay;



    private Integer shopStatus;

    private String shopBusinessInfo;

    private String shopManagedangerous;

    private String shopManagestatus;

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopBusinessHours() {
        return shopBusinessHours;
    }

    public void setShopBusinessHours(String shopBusinessHours) {
        this.shopBusinessHours = shopBusinessHours;
    }

    public String getShopPay() {
        return shopPay;
    }

    public void setShopPay(String shopPay) {
        this.shopPay = shopPay;
    }



    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopBusinessInfo() {
        return shopBusinessInfo;
    }

    public void setShopBusinessInfo(String shopBusinessInfo) {
        this.shopBusinessInfo = shopBusinessInfo;
    }

    public String getShopManagedangerous() {
        return shopManagedangerous;
    }

    public void setShopManagedangerous(String shopManagedangerous) {
        this.shopManagedangerous = shopManagedangerous;
    }

    public String getShopManagestatus() {
        return shopManagestatus;
    }

    public void setShopManagestatus(String shopManagestatus) {
        this.shopManagestatus = shopManagestatus;
    }
}