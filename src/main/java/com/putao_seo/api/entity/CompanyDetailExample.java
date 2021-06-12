package com.putao_seo.api.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetailExample {

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

    public CompanyDetailExample() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIsNull() {
            addCriterion("company_img is null");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIsNotNull() {
            addCriterion("company_img is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyImgEqualTo(String value) {
            addCriterion("company_img =", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotEqualTo(String value) {
            addCriterion("company_img <>", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgGreaterThan(String value) {
            addCriterion("company_img >", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgGreaterThanOrEqualTo(String value) {
            addCriterion("company_img >=", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLessThan(String value) {
            addCriterion("company_img <", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLessThanOrEqualTo(String value) {
            addCriterion("company_img <=", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgLike(String value) {
            addCriterion("company_img like", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotLike(String value) {
            addCriterion("company_img not like", value, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgIn(List<String> values) {
            addCriterion("company_img in", values, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotIn(List<String> values) {
            addCriterion("company_img not in", values, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgBetween(String value1, String value2) {
            addCriterion("company_img between", value1, value2, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyImgNotBetween(String value1, String value2) {
            addCriterion("company_img not between", value1, value2, "companyImg");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNull() {
            addCriterion("company_tel is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNotNull() {
            addCriterion("company_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEqualTo(String value) {
            addCriterion("company_tel =", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotEqualTo(String value) {
            addCriterion("company_tel <>", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThan(String value) {
            addCriterion("company_tel >", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThanOrEqualTo(String value) {
            addCriterion("company_tel >=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThan(String value) {
            addCriterion("company_tel <", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThanOrEqualTo(String value) {
            addCriterion("company_tel <=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLike(String value) {
            addCriterion("company_tel like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotLike(String value) {
            addCriterion("company_tel not like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIn(List<String> values) {
            addCriterion("company_tel in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotIn(List<String> values) {
            addCriterion("company_tel not in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelBetween(String value1, String value2) {
            addCriterion("company_tel between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotBetween(String value1, String value2) {
            addCriterion("company_tel not between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressIsNull() {
            addCriterion("company_tel_email_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressIsNotNull() {
            addCriterion("company_tel_email_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressEqualTo(String value) {
            addCriterion("company_tel_email_address =", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressNotEqualTo(String value) {
            addCriterion("company_tel_email_address <>", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressGreaterThan(String value) {
            addCriterion("company_tel_email_address >", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_tel_email_address >=", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressLessThan(String value) {
            addCriterion("company_tel_email_address <", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("company_tel_email_address <=", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressLike(String value) {
            addCriterion("company_tel_email_address like", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressNotLike(String value) {
            addCriterion("company_tel_email_address not like", value, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressIn(List<String> values) {
            addCriterion("company_tel_email_address in", values, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressNotIn(List<String> values) {
            addCriterion("company_tel_email_address not in", values, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressBetween(String value1, String value2) {
            addCriterion("company_tel_email_address between", value1, value2, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEmailAddressNotBetween(String value1, String value2) {
            addCriterion("company_tel_email_address not between", value1, value2, "companyTelEmailAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyDescIsNull() {
            addCriterion("company_desc is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDescIsNotNull() {
            addCriterion("company_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDescEqualTo(String value) {
            addCriterion("company_desc =", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescNotEqualTo(String value) {
            addCriterion("company_desc <>", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescGreaterThan(String value) {
            addCriterion("company_desc >", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescGreaterThanOrEqualTo(String value) {
            addCriterion("company_desc >=", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescLessThan(String value) {
            addCriterion("company_desc <", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescLessThanOrEqualTo(String value) {
            addCriterion("company_desc <=", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescLike(String value) {
            addCriterion("company_desc like", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescNotLike(String value) {
            addCriterion("company_desc not like", value, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescIn(List<String> values) {
            addCriterion("company_desc in", values, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescNotIn(List<String> values) {
            addCriterion("company_desc not in", values, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescBetween(String value1, String value2) {
            addCriterion("company_desc between", value1, value2, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyDescNotBetween(String value1, String value2) {
            addCriterion("company_desc not between", value1, value2, "companyDesc");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoIsNull() {
            addCriterion("company_business_info is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoIsNotNull() {
            addCriterion("company_business_info is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoEqualTo(String value) {
            addCriterion("company_business_info =", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoNotEqualTo(String value) {
            addCriterion("company_business_info <>", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoGreaterThan(String value) {
            addCriterion("company_business_info >", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_info >=", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoLessThan(String value) {
            addCriterion("company_business_info <", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoLessThanOrEqualTo(String value) {
            addCriterion("company_business_info <=", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoLike(String value) {
            addCriterion("company_business_info like", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoNotLike(String value) {
            addCriterion("company_business_info not like", value, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoIn(List<String> values) {
            addCriterion("company_business_info in", values, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoNotIn(List<String> values) {
            addCriterion("company_business_info not in", values, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoBetween(String value1, String value2) {
            addCriterion("company_business_info between", value1, value2, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessInfoNotBetween(String value1, String value2) {
            addCriterion("company_business_info not between", value1, value2, "companyBusinessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousIsNull() {
            addCriterion("company_manageDangerous is null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousIsNotNull() {
            addCriterion("company_manageDangerous is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousEqualTo(String value) {
            addCriterion("company_manageDangerous =", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousNotEqualTo(String value) {
            addCriterion("company_manageDangerous <>", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousGreaterThan(String value) {
            addCriterion("company_manageDangerous >", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousGreaterThanOrEqualTo(String value) {
            addCriterion("company_manageDangerous >=", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousLessThan(String value) {
            addCriterion("company_manageDangerous <", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousLessThanOrEqualTo(String value) {
            addCriterion("company_manageDangerous <=", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousLike(String value) {
            addCriterion("company_manageDangerous like", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousNotLike(String value) {
            addCriterion("company_manageDangerous not like", value, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousIn(List<String> values) {
            addCriterion("company_manageDangerous in", values, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousNotIn(List<String> values) {
            addCriterion("company_manageDangerous not in", values, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousBetween(String value1, String value2) {
            addCriterion("company_manageDangerous between", value1, value2, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagedangerousNotBetween(String value1, String value2) {
            addCriterion("company_manageDangerous not between", value1, value2, "companyManagedangerous");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusIsNull() {
            addCriterion("company_manageStatus is null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusIsNotNull() {
            addCriterion("company_manageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusEqualTo(String value) {
            addCriterion("company_manageStatus =", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusNotEqualTo(String value) {
            addCriterion("company_manageStatus <>", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusGreaterThan(String value) {
            addCriterion("company_manageStatus >", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusGreaterThanOrEqualTo(String value) {
            addCriterion("company_manageStatus >=", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusLessThan(String value) {
            addCriterion("company_manageStatus <", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusLessThanOrEqualTo(String value) {
            addCriterion("company_manageStatus <=", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusLike(String value) {
            addCriterion("company_manageStatus like", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusNotLike(String value) {
            addCriterion("company_manageStatus not like", value, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusIn(List<String> values) {
            addCriterion("company_manageStatus in", values, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusNotIn(List<String> values) {
            addCriterion("company_manageStatus not in", values, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusBetween(String value1, String value2) {
            addCriterion("company_manageStatus between", value1, value2, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyManagestatusNotBetween(String value1, String value2) {
            addCriterion("company_manageStatus not between", value1, value2, "companyManagestatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIsNull() {
            addCriterion("company_status is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIsNotNull() {
            addCriterion("company_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusEqualTo(Integer value) {
            addCriterion("company_status =", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotEqualTo(Integer value) {
            addCriterion("company_status <>", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusGreaterThan(Integer value) {
            addCriterion("company_status >", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_status >=", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusLessThan(Integer value) {
            addCriterion("company_status <", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("company_status <=", value, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusIn(List<Integer> values) {
            addCriterion("company_status in", values, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotIn(List<Integer> values) {
            addCriterion("company_status not in", values, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusBetween(Integer value1, Integer value2) {
            addCriterion("company_status between", value1, value2, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("company_status not between", value1, value2, "companyStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngIsNull() {
            addCriterion("company_latlng is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngIsNotNull() {
            addCriterion("company_latlng is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngEqualTo(String value) {
            addCriterion("company_latlng =", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngNotEqualTo(String value) {
            addCriterion("company_latlng <>", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngGreaterThan(String value) {
            addCriterion("company_latlng >", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngGreaterThanOrEqualTo(String value) {
            addCriterion("company_latlng >=", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngLessThan(String value) {
            addCriterion("company_latlng <", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngLessThanOrEqualTo(String value) {
            addCriterion("company_latlng <=", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngLike(String value) {
            addCriterion("company_latlng like", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngNotLike(String value) {
            addCriterion("company_latlng not like", value, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngIn(List<String> values) {
            addCriterion("company_latlng in", values, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngNotIn(List<String> values) {
            addCriterion("company_latlng not in", values, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngBetween(String value1, String value2) {
            addCriterion("company_latlng between", value1, value2, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyLatlngNotBetween(String value1, String value2) {
            addCriterion("company_latlng not between", value1, value2, "companyLatlng");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionIsNull() {
            addCriterion("company_region is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionIsNotNull() {
            addCriterion("company_region is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionEqualTo(String value) {
            addCriterion("company_region =", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionNotEqualTo(String value) {
            addCriterion("company_region <>", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionGreaterThan(String value) {
            addCriterion("company_region >", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionGreaterThanOrEqualTo(String value) {
            addCriterion("company_region >=", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionLessThan(String value) {
            addCriterion("company_region <", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionLessThanOrEqualTo(String value) {
            addCriterion("company_region <=", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionLike(String value) {
            addCriterion("company_region like", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionNotLike(String value) {
            addCriterion("company_region not like", value, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionIn(List<String> values) {
            addCriterion("company_region in", values, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionNotIn(List<String> values) {
            addCriterion("company_region not in", values, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionBetween(String value1, String value2) {
            addCriterion("company_region between", value1, value2, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyRegionNotBetween(String value1, String value2) {
            addCriterion("company_region not between", value1, value2, "companyRegion");
            return (Criteria) this;
        }

        public Criteria andCompanyStarIsNull() {
            addCriterion("company_star is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStarIsNotNull() {
            addCriterion("company_star is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStarEqualTo(String value) {
            addCriterion("company_star =", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarNotEqualTo(String value) {
            addCriterion("company_star <>", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarGreaterThan(String value) {
            addCriterion("company_star >", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarGreaterThanOrEqualTo(String value) {
            addCriterion("company_star >=", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarLessThan(String value) {
            addCriterion("company_star <", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarLessThanOrEqualTo(String value) {
            addCriterion("company_star <=", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarLike(String value) {
            addCriterion("company_star like", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarNotLike(String value) {
            addCriterion("company_star not like", value, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarIn(List<String> values) {
            addCriterion("company_star in", values, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarNotIn(List<String> values) {
            addCriterion("company_star not in", values, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarBetween(String value1, String value2) {
            addCriterion("company_star between", value1, value2, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyStarNotBetween(String value1, String value2) {
            addCriterion("company_star not between", value1, value2, "companyStar");
            return (Criteria) this;
        }

        public Criteria andCompanyTagIsNull() {
            addCriterion("company_tag is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTagIsNotNull() {
            addCriterion("company_tag is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTagEqualTo(String value) {
            addCriterion("company_tag =", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagNotEqualTo(String value) {
            addCriterion("company_tag <>", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagGreaterThan(String value) {
            addCriterion("company_tag >", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagGreaterThanOrEqualTo(String value) {
            addCriterion("company_tag >=", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagLessThan(String value) {
            addCriterion("company_tag <", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagLessThanOrEqualTo(String value) {
            addCriterion("company_tag <=", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagLike(String value) {
            addCriterion("company_tag like", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagNotLike(String value) {
            addCriterion("company_tag not like", value, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagIn(List<String> values) {
            addCriterion("company_tag in", values, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagNotIn(List<String> values) {
            addCriterion("company_tag not in", values, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagBetween(String value1, String value2) {
            addCriterion("company_tag between", value1, value2, "companyTag");
            return (Criteria) this;
        }

        public Criteria andCompanyTagNotBetween(String value1, String value2) {
            addCriterion("company_tag not between", value1, value2, "companyTag");
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