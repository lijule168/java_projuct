package com.putao_seo.api.entity;

import java.io.Serializable;

/**
 * @author : tangtonglong
 * 2019/5/17 11:16
 * @return
 */
public class ShopBrief implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long shopId;

    private String shopName;

    private String shopImg;

    private String shopStar;

    private String shopTel;

    private String shopCommentCount;

    private String shopPrice;

    private String shopAddress;

    private String shopLatlng;

    private String shopRegion;

    private String shopTag;

    private String shopServiceTag;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopStar() {
        return shopStar;
    }

    public void setShopStar(String shopStar) {
        this.shopStar = shopStar;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public String getShopCommentCount() {
        return shopCommentCount;
    }

    public void setShopCommentCount(String shopCommentCount) {
        this.shopCommentCount = shopCommentCount;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopLatlng() {
        return shopLatlng;
    }

    public void setShopLatlng(String shopLatlng) {
        this.shopLatlng = shopLatlng;
    }

    public String getShopRegion() {
        return shopRegion;
    }

    public void setShopRegion(String shopRegion) {
        this.shopRegion = shopRegion;
    }

    public String getShopTag() {
        return shopTag;
    }

    public void setShopTag(String shopTag) {
        this.shopTag = shopTag;
    }

    public String getShopServiceTag() {
        return shopServiceTag;
    }

    public void setShopServiceTag(String shopServiceTag) {
        this.shopServiceTag = shopServiceTag;
    }
}
