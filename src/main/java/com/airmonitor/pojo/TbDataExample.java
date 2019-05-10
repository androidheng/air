package com.airmonitor.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andPm2IsNull() {
            addCriterion("PM2 is null");
            return (Criteria) this;
        }

        public Criteria andPm2IsNotNull() {
            addCriterion("PM2 is not null");
            return (Criteria) this;
        }

        public Criteria andPm2EqualTo(String value) {
            addCriterion("PM2 =", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotEqualTo(String value) {
            addCriterion("PM2 <>", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2GreaterThan(String value) {
            addCriterion("PM2 >", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2GreaterThanOrEqualTo(String value) {
            addCriterion("PM2 >=", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2LessThan(String value) {
            addCriterion("PM2 <", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2LessThanOrEqualTo(String value) {
            addCriterion("PM2 <=", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2Like(String value) {
            addCriterion("PM2 like", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotLike(String value) {
            addCriterion("PM2 not like", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2In(List<String> values) {
            addCriterion("PM2 in", values, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotIn(List<String> values) {
            addCriterion("PM2 not in", values, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2Between(String value1, String value2) {
            addCriterion("PM2 between", value1, value2, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotBetween(String value1, String value2) {
            addCriterion("PM2 not between", value1, value2, "pm2");
            return (Criteria) this;
        }

        public Criteria andAqiIsNull() {
            addCriterion("AQI is null");
            return (Criteria) this;
        }

        public Criteria andAqiIsNotNull() {
            addCriterion("AQI is not null");
            return (Criteria) this;
        }

        public Criteria andAqiEqualTo(String value) {
            addCriterion("AQI =", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotEqualTo(String value) {
            addCriterion("AQI <>", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiGreaterThan(String value) {
            addCriterion("AQI >", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiGreaterThanOrEqualTo(String value) {
            addCriterion("AQI >=", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLessThan(String value) {
            addCriterion("AQI <", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLessThanOrEqualTo(String value) {
            addCriterion("AQI <=", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiLike(String value) {
            addCriterion("AQI like", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotLike(String value) {
            addCriterion("AQI not like", value, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiIn(List<String> values) {
            addCriterion("AQI in", values, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotIn(List<String> values) {
            addCriterion("AQI not in", values, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiBetween(String value1, String value2) {
            addCriterion("AQI between", value1, value2, "aqi");
            return (Criteria) this;
        }

        public Criteria andAqiNotBetween(String value1, String value2) {
            addCriterion("AQI not between", value1, value2, "aqi");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andPm10IsNull() {
            addCriterion("PM10 is null");
            return (Criteria) this;
        }

        public Criteria andPm10IsNotNull() {
            addCriterion("PM10 is not null");
            return (Criteria) this;
        }

        public Criteria andPm10EqualTo(String value) {
            addCriterion("PM10 =", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotEqualTo(String value) {
            addCriterion("PM10 <>", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThan(String value) {
            addCriterion("PM10 >", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThanOrEqualTo(String value) {
            addCriterion("PM10 >=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThan(String value) {
            addCriterion("PM10 <", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThanOrEqualTo(String value) {
            addCriterion("PM10 <=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Like(String value) {
            addCriterion("PM10 like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotLike(String value) {
            addCriterion("PM10 not like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10In(List<String> values) {
            addCriterion("PM10 in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotIn(List<String> values) {
            addCriterion("PM10 not in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Between(String value1, String value2) {
            addCriterion("PM10 between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotBetween(String value1, String value2) {
            addCriterion("PM10 not between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andCoIsNull() {
            addCriterion("CO is null");
            return (Criteria) this;
        }

        public Criteria andCoIsNotNull() {
            addCriterion("CO is not null");
            return (Criteria) this;
        }

        public Criteria andCoEqualTo(String value) {
            addCriterion("CO =", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotEqualTo(String value) {
            addCriterion("CO <>", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThan(String value) {
            addCriterion("CO >", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThanOrEqualTo(String value) {
            addCriterion("CO >=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThan(String value) {
            addCriterion("CO <", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThanOrEqualTo(String value) {
            addCriterion("CO <=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLike(String value) {
            addCriterion("CO like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotLike(String value) {
            addCriterion("CO not like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoIn(List<String> values) {
            addCriterion("CO in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotIn(List<String> values) {
            addCriterion("CO not in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoBetween(String value1, String value2) {
            addCriterion("CO between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotBetween(String value1, String value2) {
            addCriterion("CO not between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andNo2IsNull() {
            addCriterion("NO2 is null");
            return (Criteria) this;
        }

        public Criteria andNo2IsNotNull() {
            addCriterion("NO2 is not null");
            return (Criteria) this;
        }

        public Criteria andNo2EqualTo(String value) {
            addCriterion("NO2 =", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotEqualTo(String value) {
            addCriterion("NO2 <>", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThan(String value) {
            addCriterion("NO2 >", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThanOrEqualTo(String value) {
            addCriterion("NO2 >=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThan(String value) {
            addCriterion("NO2 <", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThanOrEqualTo(String value) {
            addCriterion("NO2 <=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Like(String value) {
            addCriterion("NO2 like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotLike(String value) {
            addCriterion("NO2 not like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2In(List<String> values) {
            addCriterion("NO2 in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotIn(List<String> values) {
            addCriterion("NO2 not in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Between(String value1, String value2) {
            addCriterion("NO2 between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotBetween(String value1, String value2) {
            addCriterion("NO2 not between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andO3IsNull() {
            addCriterion("O3 is null");
            return (Criteria) this;
        }

        public Criteria andO3IsNotNull() {
            addCriterion("O3 is not null");
            return (Criteria) this;
        }

        public Criteria andO3EqualTo(String value) {
            addCriterion("O3 =", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotEqualTo(String value) {
            addCriterion("O3 <>", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThan(String value) {
            addCriterion("O3 >", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThanOrEqualTo(String value) {
            addCriterion("O3 >=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThan(String value) {
            addCriterion("O3 <", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThanOrEqualTo(String value) {
            addCriterion("O3 <=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Like(String value) {
            addCriterion("O3 like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotLike(String value) {
            addCriterion("O3 not like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3In(List<String> values) {
            addCriterion("O3 in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotIn(List<String> values) {
            addCriterion("O3 not in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Between(String value1, String value2) {
            addCriterion("O3 between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotBetween(String value1, String value2) {
            addCriterion("O3 not between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andSo2IsNull() {
            addCriterion("SO2 is null");
            return (Criteria) this;
        }

        public Criteria andSo2IsNotNull() {
            addCriterion("SO2 is not null");
            return (Criteria) this;
        }

        public Criteria andSo2EqualTo(String value) {
            addCriterion("SO2 =", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotEqualTo(String value) {
            addCriterion("SO2 <>", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThan(String value) {
            addCriterion("SO2 >", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThanOrEqualTo(String value) {
            addCriterion("SO2 >=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThan(String value) {
            addCriterion("SO2 <", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThanOrEqualTo(String value) {
            addCriterion("SO2 <=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Like(String value) {
            addCriterion("SO2 like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotLike(String value) {
            addCriterion("SO2 not like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2In(List<String> values) {
            addCriterion("SO2 in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotIn(List<String> values) {
            addCriterion("SO2 not in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Between(String value1, String value2) {
            addCriterion("SO2 between", value1, value2, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotBetween(String value1, String value2) {
            addCriterion("SO2 not between", value1, value2, "so2");
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

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andMainIsNull() {
            addCriterion("main is null");
            return (Criteria) this;
        }

        public Criteria andMainIsNotNull() {
            addCriterion("main is not null");
            return (Criteria) this;
        }

        public Criteria andMainEqualTo(String value) {
            addCriterion("main =", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainNotEqualTo(String value) {
            addCriterion("main <>", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainGreaterThan(String value) {
            addCriterion("main >", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainGreaterThanOrEqualTo(String value) {
            addCriterion("main >=", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainLessThan(String value) {
            addCriterion("main <", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainLessThanOrEqualTo(String value) {
            addCriterion("main <=", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainLike(String value) {
            addCriterion("main like", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainNotLike(String value) {
            addCriterion("main not like", value, "main");
            return (Criteria) this;
        }

        public Criteria andMainIn(List<String> values) {
            addCriterion("main in", values, "main");
            return (Criteria) this;
        }

        public Criteria andMainNotIn(List<String> values) {
            addCriterion("main not in", values, "main");
            return (Criteria) this;
        }

        public Criteria andMainBetween(String value1, String value2) {
            addCriterion("main between", value1, value2, "main");
            return (Criteria) this;
        }

        public Criteria andMainNotBetween(String value1, String value2) {
            addCriterion("main not between", value1, value2, "main");
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