package com.cdtu.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        public Criteria andEmpidIsNull() {
            addCriterion("empid is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empid =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empid <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empid >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empid >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empid <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empid <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empid in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empid not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empid between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empid not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empname is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empname is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empname =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empname <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empname >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empname >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empname <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empname <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empname like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empname not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empname in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empname not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empname between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empname not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpemailIsNull() {
            addCriterion("empemail is null");
            return (Criteria) this;
        }

        public Criteria andEmpemailIsNotNull() {
            addCriterion("empemail is not null");
            return (Criteria) this;
        }

        public Criteria andEmpemailEqualTo(String value) {
            addCriterion("empemail =", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailNotEqualTo(String value) {
            addCriterion("empemail <>", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailGreaterThan(String value) {
            addCriterion("empemail >", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailGreaterThanOrEqualTo(String value) {
            addCriterion("empemail >=", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailLessThan(String value) {
            addCriterion("empemail <", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailLessThanOrEqualTo(String value) {
            addCriterion("empemail <=", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailLike(String value) {
            addCriterion("empemail like", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailNotLike(String value) {
            addCriterion("empemail not like", value, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailIn(List<String> values) {
            addCriterion("empemail in", values, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailNotIn(List<String> values) {
            addCriterion("empemail not in", values, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailBetween(String value1, String value2) {
            addCriterion("empemail between", value1, value2, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpemailNotBetween(String value1, String value2) {
            addCriterion("empemail not between", value1, value2, "empemail");
            return (Criteria) this;
        }

        public Criteria andEmpaddrIsNull() {
            addCriterion("empaddr is null");
            return (Criteria) this;
        }

        public Criteria andEmpaddrIsNotNull() {
            addCriterion("empaddr is not null");
            return (Criteria) this;
        }

        public Criteria andEmpaddrEqualTo(String value) {
            addCriterion("empaddr =", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrNotEqualTo(String value) {
            addCriterion("empaddr <>", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrGreaterThan(String value) {
            addCriterion("empaddr >", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrGreaterThanOrEqualTo(String value) {
            addCriterion("empaddr >=", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrLessThan(String value) {
            addCriterion("empaddr <", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrLessThanOrEqualTo(String value) {
            addCriterion("empaddr <=", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrLike(String value) {
            addCriterion("empaddr like", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrNotLike(String value) {
            addCriterion("empaddr not like", value, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrIn(List<String> values) {
            addCriterion("empaddr in", values, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrNotIn(List<String> values) {
            addCriterion("empaddr not in", values, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrBetween(String value1, String value2) {
            addCriterion("empaddr between", value1, value2, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpaddrNotBetween(String value1, String value2) {
            addCriterion("empaddr not between", value1, value2, "empaddr");
            return (Criteria) this;
        }

        public Criteria andEmpdepidIsNull() {
            addCriterion("empdepid is null");
            return (Criteria) this;
        }

        public Criteria andEmpdepidIsNotNull() {
            addCriterion("empdepid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpdepidEqualTo(Integer value) {
            addCriterion("empdepid =", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidNotEqualTo(Integer value) {
            addCriterion("empdepid <>", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidGreaterThan(Integer value) {
            addCriterion("empdepid >", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empdepid >=", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidLessThan(Integer value) {
            addCriterion("empdepid <", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidLessThanOrEqualTo(Integer value) {
            addCriterion("empdepid <=", value, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidIn(List<Integer> values) {
            addCriterion("empdepid in", values, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidNotIn(List<Integer> values) {
            addCriterion("empdepid not in", values, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidBetween(Integer value1, Integer value2) {
            addCriterion("empdepid between", value1, value2, "empdepid");
            return (Criteria) this;
        }

        public Criteria andEmpdepidNotBetween(Integer value1, Integer value2) {
            addCriterion("empdepid not between", value1, value2, "empdepid");
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