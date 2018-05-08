package com.hub.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NirmodelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NirmodelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNull() {
            addCriterion("modelname is null");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNotNull() {
            addCriterion("modelname is not null");
            return (Criteria) this;
        }

        public Criteria andModelnameEqualTo(String value) {
            addCriterion("modelname =", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotEqualTo(String value) {
            addCriterion("modelname <>", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThan(String value) {
            addCriterion("modelname >", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThanOrEqualTo(String value) {
            addCriterion("modelname >=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThan(String value) {
            addCriterion("modelname <", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThanOrEqualTo(String value) {
            addCriterion("modelname <=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLike(String value) {
            addCriterion("modelname like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotLike(String value) {
            addCriterion("modelname not like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameIn(List<String> values) {
            addCriterion("modelname in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotIn(List<String> values) {
            addCriterion("modelname not in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameBetween(String value1, String value2) {
            addCriterion("modelname between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotBetween(String value1, String value2) {
            addCriterion("modelname not between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNull() {
            addCriterion("interval is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNotNull() {
            addCriterion("interval is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalEqualTo(String value) {
            addCriterion("interval =", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotEqualTo(String value) {
            addCriterion("interval <>", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThan(String value) {
            addCriterion("interval >", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("interval >=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThan(String value) {
            addCriterion("interval <", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThanOrEqualTo(String value) {
            addCriterion("interval <=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLike(String value) {
            addCriterion("interval like", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotLike(String value) {
            addCriterion("interval not like", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalIn(List<String> values) {
            addCriterion("interval in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotIn(List<String> values) {
            addCriterion("interval not in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalBetween(String value1, String value2) {
            addCriterion("interval between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotBetween(String value1, String value2) {
            addCriterion("interval not between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andConstantIsNull() {
            addCriterion("constant is null");
            return (Criteria) this;
        }

        public Criteria andConstantIsNotNull() {
            addCriterion("constant is not null");
            return (Criteria) this;
        }

        public Criteria andConstantEqualTo(Double value) {
            addCriterion("constant =", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantNotEqualTo(Double value) {
            addCriterion("constant <>", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantGreaterThan(Double value) {
            addCriterion("constant >", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantGreaterThanOrEqualTo(Double value) {
            addCriterion("constant >=", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantLessThan(Double value) {
            addCriterion("constant <", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantLessThanOrEqualTo(Double value) {
            addCriterion("constant <=", value, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantIn(List<Double> values) {
            addCriterion("constant in", values, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantNotIn(List<Double> values) {
            addCriterion("constant not in", values, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantBetween(Double value1, Double value2) {
            addCriterion("constant between", value1, value2, "constant");
            return (Criteria) this;
        }

        public Criteria andConstantNotBetween(Double value1, Double value2) {
            addCriterion("constant not between", value1, value2, "constant");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNull() {
            addCriterion("uploader is null");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNotNull() {
            addCriterion("uploader is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderEqualTo(String value) {
            addCriterion("uploader =", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotEqualTo(String value) {
            addCriterion("uploader <>", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThan(String value) {
            addCriterion("uploader >", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThanOrEqualTo(String value) {
            addCriterion("uploader >=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThan(String value) {
            addCriterion("uploader <", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThanOrEqualTo(String value) {
            addCriterion("uploader <=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLike(String value) {
            addCriterion("uploader like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotLike(String value) {
            addCriterion("uploader not like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderIn(List<String> values) {
            addCriterion("uploader in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotIn(List<String> values) {
            addCriterion("uploader not in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderBetween(String value1, String value2) {
            addCriterion("uploader between", value1, value2, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotBetween(String value1, String value2) {
            addCriterion("uploader not between", value1, value2, "uploader");
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