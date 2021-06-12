package com.putao_seo.api.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : tangtonglong
 * 2019/5/16 10:51
 * @return
 */

public class ArticleBrief implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer articleid;

    private String title;

    private String description;

    private String author;


//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
////    @DateTimeFormat(iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME)
////    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDateTime createtime;

    private LocalDate createtime;

    private Integer categoryid;

    private String keywords;

    private Integer articleStatus;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public LocalDate getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }


    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }
}
