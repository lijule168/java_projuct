package com.putao_seo.api.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer commentId;

    private Long shopId;

    private String commentUserImg;

    private String commentUserName;

    private Integer commentStar;

    private String commentScore;

    private String commentContent;

//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime commentTime;

    private LocalDate commentTime;

    private String commentImgs;

    private String commentFollows;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCommentUserImg() {
        return commentUserImg;
    }

    public void setCommentUserImg(String commentUserImg) {
        this.commentUserImg = commentUserImg;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public Integer getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(Integer commentStar) {
        this.commentStar = commentStar;
    }

    public String getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(String commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDate commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentImgs() {
        return commentImgs;
    }

    public void setCommentImgs(String commentImgs) {
        this.commentImgs = commentImgs;
    }

    public String getCommentFollows() {
        return commentFollows;
    }

    public void setCommentFollows(String commentFollows) {
        this.commentFollows = commentFollows;
    }
}