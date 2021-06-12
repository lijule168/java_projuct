package com.putao_seo.api.entity;

import java.util.ArrayList;
import java.util.List;

public class ShopDetailExample {

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

    public ShopDetailExample() {
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNull() {
            addCriterion("shop_img is null");
            return (Criteria) this;
        }

        public Criteria andShopImgIsNotNull() {
            addCriterion("shop_img is not null");
            return (Criteria) this;
        }

        public Criteria andShopImgEqualTo(String value) {
            addCriterion("shop_img =", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotEqualTo(String value) {
            addCriterion("shop_img <>", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThan(String value) {
            addCriterion("shop_img >", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgGreaterThanOrEqualTo(String value) {
            addCriterion("shop_img >=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThan(String value) {
            addCriterion("shop_img <", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLessThanOrEqualTo(String value) {
            addCriterion("shop_img <=", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgLike(String value) {
            addCriterion("shop_img like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotLike(String value) {
            addCriterion("shop_img not like", value, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgIn(List<String> values) {
            addCriterion("shop_img in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotIn(List<String> values) {
            addCriterion("shop_img not in", values, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgBetween(String value1, String value2) {
            addCriterion("shop_img between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopImgNotBetween(String value1, String value2) {
            addCriterion("shop_img not between", value1, value2, "shopImg");
            return (Criteria) this;
        }

        public Criteria andShopStarIsNull() {
            addCriterion("shop_star is null");
            return (Criteria) this;
        }

        public Criteria andShopStarIsNotNull() {
            addCriterion("shop_star is not null");
            return (Criteria) this;
        }

        public Criteria andShopStarEqualTo(String value) {
            addCriterion("shop_star =", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotEqualTo(String value) {
            addCriterion("shop_star <>", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarGreaterThan(String value) {
            addCriterion("shop_star >", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarGreaterThanOrEqualTo(String value) {
            addCriterion("shop_star >=", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarLessThan(String value) {
            addCriterion("shop_star <", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarLessThanOrEqualTo(String value) {
            addCriterion("shop_star <=", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarLike(String value) {
            addCriterion("shop_star like", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotLike(String value) {
            addCriterion("shop_star not like", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarIn(List<String> values) {
            addCriterion("shop_star in", values, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotIn(List<String> values) {
            addCriterion("shop_star not in", values, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarBetween(String value1, String value2) {
            addCriterion("shop_star between", value1, value2, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotBetween(String value1, String value2) {
            addCriterion("shop_star not between", value1, value2, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopTelIsNull() {
            addCriterion("shop_tel is null");
            return (Criteria) this;
        }

        public Criteria andShopTelIsNotNull() {
            addCriterion("shop_tel is not null");
            return (Criteria) this;
        }

        public Criteria andShopTelEqualTo(String value) {
            addCriterion("shop_tel =", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotEqualTo(String value) {
            addCriterion("shop_tel <>", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelGreaterThan(String value) {
            addCriterion("shop_tel >", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelGreaterThanOrEqualTo(String value) {
            addCriterion("shop_tel >=", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLessThan(String value) {
            addCriterion("shop_tel <", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLessThanOrEqualTo(String value) {
            addCriterion("shop_tel <=", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLike(String value) {
            addCriterion("shop_tel like", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotLike(String value) {
            addCriterion("shop_tel not like", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelIn(List<String> values) {
            addCriterion("shop_tel in", values, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotIn(List<String> values) {
            addCriterion("shop_tel not in", values, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelBetween(String value1, String value2) {
            addCriterion("shop_tel between", value1, value2, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotBetween(String value1, String value2) {
            addCriterion("shop_tel not between", value1, value2, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountIsNull() {
            addCriterion("shop_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountIsNotNull() {
            addCriterion("shop_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountEqualTo(String value) {
            addCriterion("shop_comment_count =", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountNotEqualTo(String value) {
            addCriterion("shop_comment_count <>", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountGreaterThan(String value) {
            addCriterion("shop_comment_count >", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountGreaterThanOrEqualTo(String value) {
            addCriterion("shop_comment_count >=", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountLessThan(String value) {
            addCriterion("shop_comment_count <", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountLessThanOrEqualTo(String value) {
            addCriterion("shop_comment_count <=", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountLike(String value) {
            addCriterion("shop_comment_count like", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountNotLike(String value) {
            addCriterion("shop_comment_count not like", value, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountIn(List<String> values) {
            addCriterion("shop_comment_count in", values, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountNotIn(List<String> values) {
            addCriterion("shop_comment_count not in", values, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountBetween(String value1, String value2) {
            addCriterion("shop_comment_count between", value1, value2, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopCommentCountNotBetween(String value1, String value2) {
            addCriterion("shop_comment_count not between", value1, value2, "shopCommentCount");
            return (Criteria) this;
        }

        public Criteria andShopPriceIsNull() {
            addCriterion("shop_price is null");
            return (Criteria) this;
        }

        public Criteria andShopPriceIsNotNull() {
            addCriterion("shop_price is not null");
            return (Criteria) this;
        }

        public Criteria andShopPriceEqualTo(String value) {
            addCriterion("shop_price =", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotEqualTo(String value) {
            addCriterion("shop_price <>", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThan(String value) {
            addCriterion("shop_price >", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThanOrEqualTo(String value) {
            addCriterion("shop_price >=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThan(String value) {
            addCriterion("shop_price <", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThanOrEqualTo(String value) {
            addCriterion("shop_price <=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLike(String value) {
            addCriterion("shop_price like", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotLike(String value) {
            addCriterion("shop_price not like", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceIn(List<String> values) {
            addCriterion("shop_price in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotIn(List<String> values) {
            addCriterion("shop_price not in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceBetween(String value1, String value2) {
            addCriterion("shop_price between", value1, value2, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotBetween(String value1, String value2) {
            addCriterion("shop_price not between", value1, value2, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopDescIsNull() {
            addCriterion("shop_desc is null");
            return (Criteria) this;
        }

        public Criteria andShopDescIsNotNull() {
            addCriterion("shop_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShopDescEqualTo(String value) {
            addCriterion("shop_desc =", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescNotEqualTo(String value) {
            addCriterion("shop_desc <>", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescGreaterThan(String value) {
            addCriterion("shop_desc >", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescGreaterThanOrEqualTo(String value) {
            addCriterion("shop_desc >=", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescLessThan(String value) {
            addCriterion("shop_desc <", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescLessThanOrEqualTo(String value) {
            addCriterion("shop_desc <=", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescLike(String value) {
            addCriterion("shop_desc like", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescNotLike(String value) {
            addCriterion("shop_desc not like", value, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescIn(List<String> values) {
            addCriterion("shop_desc in", values, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescNotIn(List<String> values) {
            addCriterion("shop_desc not in", values, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescBetween(String value1, String value2) {
            addCriterion("shop_desc between", value1, value2, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopDescNotBetween(String value1, String value2) {
            addCriterion("shop_desc not between", value1, value2, "shopDesc");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursIsNull() {
            addCriterion("shop_business_hours is null");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursIsNotNull() {
            addCriterion("shop_business_hours is not null");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursEqualTo(String value) {
            addCriterion("shop_business_hours =", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursNotEqualTo(String value) {
            addCriterion("shop_business_hours <>", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursGreaterThan(String value) {
            addCriterion("shop_business_hours >", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursGreaterThanOrEqualTo(String value) {
            addCriterion("shop_business_hours >=", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursLessThan(String value) {
            addCriterion("shop_business_hours <", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursLessThanOrEqualTo(String value) {
            addCriterion("shop_business_hours <=", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursLike(String value) {
            addCriterion("shop_business_hours like", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursNotLike(String value) {
            addCriterion("shop_business_hours not like", value, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursIn(List<String> values) {
            addCriterion("shop_business_hours in", values, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursNotIn(List<String> values) {
            addCriterion("shop_business_hours not in", values, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursBetween(String value1, String value2) {
            addCriterion("shop_business_hours between", value1, value2, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopBusinessHoursNotBetween(String value1, String value2) {
            addCriterion("shop_business_hours not between", value1, value2, "shopBusinessHours");
            return (Criteria) this;
        }

        public Criteria andShopPayIsNull() {
            addCriterion("shop_pay is null");
            return (Criteria) this;
        }

        public Criteria andShopPayIsNotNull() {
            addCriterion("shop_pay is not null");
            return (Criteria) this;
        }

        public Criteria andShopPayEqualTo(String value) {
            addCriterion("shop_pay =", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayNotEqualTo(String value) {
            addCriterion("shop_pay <>", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayGreaterThan(String value) {
            addCriterion("shop_pay >", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayGreaterThanOrEqualTo(String value) {
            addCriterion("shop_pay >=", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayLessThan(String value) {
            addCriterion("shop_pay <", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayLessThanOrEqualTo(String value) {
            addCriterion("shop_pay <=", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayLike(String value) {
            addCriterion("shop_pay like", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayNotLike(String value) {
            addCriterion("shop_pay not like", value, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayIn(List<String> values) {
            addCriterion("shop_pay in", values, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayNotIn(List<String> values) {
            addCriterion("shop_pay not in", values, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayBetween(String value1, String value2) {
            addCriterion("shop_pay between", value1, value2, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopPayNotBetween(String value1, String value2) {
            addCriterion("shop_pay not between", value1, value2, "shopPay");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("shop_address =", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("shop_address <", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLike(String value) {
            addCriterion("shop_address like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("shop_address not like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("shop_address in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopLatlngIsNull() {
            addCriterion("shop_latlng is null");
            return (Criteria) this;
        }

        public Criteria andShopLatlngIsNotNull() {
            addCriterion("shop_latlng is not null");
            return (Criteria) this;
        }

        public Criteria andShopLatlngEqualTo(String value) {
            addCriterion("shop_latlng =", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngNotEqualTo(String value) {
            addCriterion("shop_latlng <>", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngGreaterThan(String value) {
            addCriterion("shop_latlng >", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngGreaterThanOrEqualTo(String value) {
            addCriterion("shop_latlng >=", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngLessThan(String value) {
            addCriterion("shop_latlng <", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngLessThanOrEqualTo(String value) {
            addCriterion("shop_latlng <=", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngLike(String value) {
            addCriterion("shop_latlng like", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngNotLike(String value) {
            addCriterion("shop_latlng not like", value, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngIn(List<String> values) {
            addCriterion("shop_latlng in", values, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngNotIn(List<String> values) {
            addCriterion("shop_latlng not in", values, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngBetween(String value1, String value2) {
            addCriterion("shop_latlng between", value1, value2, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopLatlngNotBetween(String value1, String value2) {
            addCriterion("shop_latlng not between", value1, value2, "shopLatlng");
            return (Criteria) this;
        }

        public Criteria andShopRegionIsNull() {
            addCriterion("shop_region is null");
            return (Criteria) this;
        }

        public Criteria andShopRegionIsNotNull() {
            addCriterion("shop_region is not null");
            return (Criteria) this;
        }

        public Criteria andShopRegionEqualTo(String value) {
            addCriterion("shop_region =", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionNotEqualTo(String value) {
            addCriterion("shop_region <>", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionGreaterThan(String value) {
            addCriterion("shop_region >", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionGreaterThanOrEqualTo(String value) {
            addCriterion("shop_region >=", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionLessThan(String value) {
            addCriterion("shop_region <", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionLessThanOrEqualTo(String value) {
            addCriterion("shop_region <=", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionLike(String value) {
            addCriterion("shop_region like", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionNotLike(String value) {
            addCriterion("shop_region not like", value, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionIn(List<String> values) {
            addCriterion("shop_region in", values, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionNotIn(List<String> values) {
            addCriterion("shop_region not in", values, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionBetween(String value1, String value2) {
            addCriterion("shop_region between", value1, value2, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopRegionNotBetween(String value1, String value2) {
            addCriterion("shop_region not between", value1, value2, "shopRegion");
            return (Criteria) this;
        }

        public Criteria andShopTagIsNull() {
            addCriterion("shop_tag is null");
            return (Criteria) this;
        }

        public Criteria andShopTagIsNotNull() {
            addCriterion("shop_tag is not null");
            return (Criteria) this;
        }

        public Criteria andShopTagEqualTo(String value) {
            addCriterion("shop_tag =", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagNotEqualTo(String value) {
            addCriterion("shop_tag <>", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagGreaterThan(String value) {
            addCriterion("shop_tag >", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagGreaterThanOrEqualTo(String value) {
            addCriterion("shop_tag >=", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagLessThan(String value) {
            addCriterion("shop_tag <", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagLessThanOrEqualTo(String value) {
            addCriterion("shop_tag <=", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagLike(String value) {
            addCriterion("shop_tag like", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagNotLike(String value) {
            addCriterion("shop_tag not like", value, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagIn(List<String> values) {
            addCriterion("shop_tag in", values, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagNotIn(List<String> values) {
            addCriterion("shop_tag not in", values, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagBetween(String value1, String value2) {
            addCriterion("shop_tag between", value1, value2, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopTagNotBetween(String value1, String value2) {
            addCriterion("shop_tag not between", value1, value2, "shopTag");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNull() {
            addCriterion("shop_status is null");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNotNull() {
            addCriterion("shop_status is not null");
            return (Criteria) this;
        }

        public Criteria andShopStatusEqualTo(Integer value) {
            addCriterion("shop_status =", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotEqualTo(Integer value) {
            addCriterion("shop_status <>", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThan(Integer value) {
            addCriterion("shop_status >", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_status >=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThan(Integer value) {
            addCriterion("shop_status <", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            addCriterion("shop_status <=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusIn(List<Integer> values) {
            addCriterion("shop_status in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotIn(List<Integer> values) {
            addCriterion("shop_status not in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusBetween(Integer value1, Integer value2) {
            addCriterion("shop_status between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_status not between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoIsNull() {
            addCriterion("shop_business_info is null");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoIsNotNull() {
            addCriterion("shop_business_info is not null");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoEqualTo(String value) {
            addCriterion("shop_business_info =", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoNotEqualTo(String value) {
            addCriterion("shop_business_info <>", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoGreaterThan(String value) {
            addCriterion("shop_business_info >", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_business_info >=", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoLessThan(String value) {
            addCriterion("shop_business_info <", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoLessThanOrEqualTo(String value) {
            addCriterion("shop_business_info <=", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoLike(String value) {
            addCriterion("shop_business_info like", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoNotLike(String value) {
            addCriterion("shop_business_info not like", value, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoIn(List<String> values) {
            addCriterion("shop_business_info in", values, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoNotIn(List<String> values) {
            addCriterion("shop_business_info not in", values, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoBetween(String value1, String value2) {
            addCriterion("shop_business_info between", value1, value2, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopBusinessInfoNotBetween(String value1, String value2) {
            addCriterion("shop_business_info not between", value1, value2, "shopBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousIsNull() {
            addCriterion("shop_manageDangerous is null");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousIsNotNull() {
            addCriterion("shop_manageDangerous is not null");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousEqualTo(String value) {
            addCriterion("shop_manageDangerous =", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousNotEqualTo(String value) {
            addCriterion("shop_manageDangerous <>", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousGreaterThan(String value) {
            addCriterion("shop_manageDangerous >", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousGreaterThanOrEqualTo(String value) {
            addCriterion("shop_manageDangerous >=", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousLessThan(String value) {
            addCriterion("shop_manageDangerous <", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousLessThanOrEqualTo(String value) {
            addCriterion("shop_manageDangerous <=", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousLike(String value) {
            addCriterion("shop_manageDangerous like", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousNotLike(String value) {
            addCriterion("shop_manageDangerous not like", value, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousIn(List<String> values) {
            addCriterion("shop_manageDangerous in", values, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousNotIn(List<String> values) {
            addCriterion("shop_manageDangerous not in", values, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousBetween(String value1, String value2) {
            addCriterion("shop_manageDangerous between", value1, value2, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagedangerousNotBetween(String value1, String value2) {
            addCriterion("shop_manageDangerous not between", value1, value2, "shopManagedangerous");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusIsNull() {
            addCriterion("shop_manageStatus is null");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusIsNotNull() {
            addCriterion("shop_manageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusEqualTo(String value) {
            addCriterion("shop_manageStatus =", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusNotEqualTo(String value) {
            addCriterion("shop_manageStatus <>", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusGreaterThan(String value) {
            addCriterion("shop_manageStatus >", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusGreaterThanOrEqualTo(String value) {
            addCriterion("shop_manageStatus >=", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusLessThan(String value) {
            addCriterion("shop_manageStatus <", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusLessThanOrEqualTo(String value) {
            addCriterion("shop_manageStatus <=", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusLike(String value) {
            addCriterion("shop_manageStatus like", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusNotLike(String value) {
            addCriterion("shop_manageStatus not like", value, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusIn(List<String> values) {
            addCriterion("shop_manageStatus in", values, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusNotIn(List<String> values) {
            addCriterion("shop_manageStatus not in", values, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusBetween(String value1, String value2) {
            addCriterion("shop_manageStatus between", value1, value2, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopManagestatusNotBetween(String value1, String value2) {
            addCriterion("shop_manageStatus not between", value1, value2, "shopManagestatus");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagIsNull() {
            addCriterion("shop_service_tag is null");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagIsNotNull() {
            addCriterion("shop_service_tag is not null");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagEqualTo(String value) {
            addCriterion("shop_service_tag =", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagNotEqualTo(String value) {
            addCriterion("shop_service_tag <>", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagGreaterThan(String value) {
            addCriterion("shop_service_tag >", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagGreaterThanOrEqualTo(String value) {
            addCriterion("shop_service_tag >=", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagLessThan(String value) {
            addCriterion("shop_service_tag <", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagLessThanOrEqualTo(String value) {
            addCriterion("shop_service_tag <=", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagLike(String value) {
            addCriterion("shop_service_tag like", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagNotLike(String value) {
            addCriterion("shop_service_tag not like", value, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagIn(List<String> values) {
            addCriterion("shop_service_tag in", values, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagNotIn(List<String> values) {
            addCriterion("shop_service_tag not in", values, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagBetween(String value1, String value2) {
            addCriterion("shop_service_tag between", value1, value2, "shopServiceTag");
            return (Criteria) this;
        }

        public Criteria andShopServiceTagNotBetween(String value1, String value2) {
            addCriterion("shop_service_tag not between", value1, value2, "shopServiceTag");
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