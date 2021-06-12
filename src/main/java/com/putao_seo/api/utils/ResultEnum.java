package com.putao_seo.api.utils;

public enum ResultEnum {
    SUCCESS(1),
    ERROR(0);

    private int code;

    private ResultEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}