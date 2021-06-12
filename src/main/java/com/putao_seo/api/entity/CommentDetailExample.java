package com.putao_seo.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentDetailExample {

    private Integer offset;

    private Integer pageSize;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgIsNull() {
            addCriterion("comment_user_img is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgIsNotNull() {
            addCriterion("comment_user_img is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgEqualTo(String value) {
            addCriterion("comment_user_img =", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgNotEqualTo(String value) {
            addCriterion("comment_user_img <>", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgGreaterThan(String value) {
            addCriterion("comment_user_img >", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_img >=", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgLessThan(String value) {
            addCriterion("comment_user_img <", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgLessThanOrEqualTo(String value) {
            addCriterion("comment_user_img <=", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgLike(String value) {
            addCriterion("comment_user_img like", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgNotLike(String value) {
            addCriterion("comment_user_img not like", value, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgIn(List<String> values) {
            addCriterion("comment_user_img in", values, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgNotIn(List<String> values) {
            addCriterion("comment_user_img not in", values, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgBetween(String value1, String value2) {
            addCriterion("comment_user_img between", value1, value2, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserImgNotBetween(String value1, String value2) {
            addCriterion("comment_user_img not between", value1, value2, "commentUserImg");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNull() {
            addCriterion("comment_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIsNotNull() {
            addCriterion("comment_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameEqualTo(String value) {
            addCriterion("comment_user_name =", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotEqualTo(String value) {
            addCriterion("comment_user_name <>", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThan(String value) {
            addCriterion("comment_user_name >", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_name >=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThan(String value) {
            addCriterion("comment_user_name <", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLessThanOrEqualTo(String value) {
            addCriterion("comment_user_name <=", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameLike(String value) {
            addCriterion("comment_user_name like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotLike(String value) {
            addCriterion("comment_user_name not like", value, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameIn(List<String> values) {
            addCriterion("comment_user_name in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotIn(List<String> values) {
            addCriterion("comment_user_name not in", values, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameBetween(String value1, String value2) {
            addCriterion("comment_user_name between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentUserNameNotBetween(String value1, String value2) {
            addCriterion("comment_user_name not between", value1, value2, "commentUserName");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNull() {
            addCriterion("comment_star is null");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNotNull() {
            addCriterion("comment_star is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStarEqualTo(Integer value) {
            addCriterion("comment_star =", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotEqualTo(Integer value) {
            addCriterion("comment_star <>", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThan(Integer value) {
            addCriterion("comment_star >", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_star >=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThan(Integer value) {
            addCriterion("comment_star <", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThanOrEqualTo(Integer value) {
            addCriterion("comment_star <=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarIn(List<Integer> values) {
            addCriterion("comment_star in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotIn(List<Integer> values) {
            addCriterion("comment_star not in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarBetween(Integer value1, Integer value2) {
            addCriterion("comment_star between", value1, value2, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_star not between", value1, value2, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNull() {
            addCriterion("comment_score is null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNotNull() {
            addCriterion("comment_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreEqualTo(String value) {
            addCriterion("comment_score =", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotEqualTo(String value) {
            addCriterion("comment_score <>", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThan(String value) {
            addCriterion("comment_score >", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThanOrEqualTo(String value) {
            addCriterion("comment_score >=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThan(String value) {
            addCriterion("comment_score <", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThanOrEqualTo(String value) {
            addCriterion("comment_score <=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLike(String value) {
            addCriterion("comment_score like", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotLike(String value) {
            addCriterion("comment_score not like", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIn(List<String> values) {
            addCriterion("comment_score in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotIn(List<String> values) {
            addCriterion("comment_score not in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreBetween(String value1, String value2) {
            addCriterion("comment_score between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotBetween(String value1, String value2) {
            addCriterion("comment_score not between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(LocalDate value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(LocalDate value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(LocalDate value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(LocalDate value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(LocalDate value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<LocalDate> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<LocalDate> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(LocalDate value1, LocalDate value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentImgsIsNull() {
            addCriterion("comment_imgs is null");
            return (Criteria) this;
        }

        public Criteria andCommentImgsIsNotNull() {
            addCriterion("comment_imgs is not null");
            return (Criteria) this;
        }

        public Criteria andCommentImgsEqualTo(String value) {
            addCriterion("comment_imgs =", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsNotEqualTo(String value) {
            addCriterion("comment_imgs <>", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsLengthGreaterThan(Integer value) {
            addCriterion("length(comment_imgs) >", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsGreaterThan(String value) {
            addCriterion("comment_imgs >", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsGreaterThanOrEqualTo(String value) {
            addCriterion("comment_imgs >=", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsLessThan(String value) {
            addCriterion("comment_imgs <", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsLessThanOrEqualTo(String value) {
            addCriterion("comment_imgs <=", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsLike(String value) {
            addCriterion("comment_imgs like", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsNotLike(String value) {
            addCriterion("comment_imgs not like", value, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsIn(List<String> values) {
            addCriterion("comment_imgs in", values, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsNotIn(List<String> values) {
            addCriterion("comment_imgs not in", values, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsBetween(String value1, String value2) {
            addCriterion("comment_imgs between", value1, value2, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentImgsNotBetween(String value1, String value2) {
            addCriterion("comment_imgs not between", value1, value2, "commentImgs");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsIsNull() {
            addCriterion("comment_follows is null");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsIsNotNull() {
            addCriterion("comment_follows is not null");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsEqualTo(String value) {
            addCriterion("comment_follows =", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsNotEqualTo(String value) {
            addCriterion("comment_follows <>", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsGreaterThan(String value) {
            addCriterion("comment_follows >", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsGreaterThanOrEqualTo(String value) {
            addCriterion("comment_follows >=", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsLessThan(String value) {
            addCriterion("comment_follows <", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsLessThanOrEqualTo(String value) {
            addCriterion("comment_follows <=", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsLike(String value) {
            addCriterion("comment_follows like", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsNotLike(String value) {
            addCriterion("comment_follows not like", value, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsIn(List<String> values) {
            addCriterion("comment_follows in", values, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsNotIn(List<String> values) {
            addCriterion("comment_follows not in", values, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsBetween(String value1, String value2) {
            addCriterion("comment_follows between", value1, value2, "commentFollows");
            return (Criteria) this;
        }

        public Criteria andCommentFollowsNotBetween(String value1, String value2) {
            addCriterion("comment_follows not between", value1, value2, "commentFollows");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}