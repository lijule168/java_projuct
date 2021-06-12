package com.putao_seo.api.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : tangtonglong
 * 2019/6/10 16:49
 * @return
 */
@Getter
@Setter
public class EsArticle {

    private static final long serialVersionUID = 1L;

    private Integer articleId;

    private String title;

    private String description;

    private String author;

    private String createTime;

    private Integer categoryId;

    private String keywords;


}
