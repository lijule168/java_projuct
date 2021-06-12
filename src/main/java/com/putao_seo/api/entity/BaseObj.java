package com.putao_seo.api.entity;

import java.io.Serializable;

/**
 * @author : tangtonglong
 * 2019/6/3 15:14
 * @return
 */
public class BaseObj implements Serializable {


    private static final long serialVersionUID = 1L;

    private String Code;

    private String Name;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
