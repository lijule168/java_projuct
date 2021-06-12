package com.putao_seo.api.entity;

import java.io.Serializable;

public class SeoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;

    private String userName;

    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}