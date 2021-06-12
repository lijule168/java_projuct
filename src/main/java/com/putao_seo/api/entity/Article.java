package com.putao_seo.api.entity;

import java.time.LocalDateTime;

public class Article extends ArticleBrief {


    private static final long serialVersionUID = 1L;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}