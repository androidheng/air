package com.airmonitor.pojo;

public class TbData {
    private Integer id;

    private Integer cid;

    private String city;

    private String pm2;

    private String aqi;

    private String quality;

    private String pm10;

    private String co;

    private String no2;

    private String o3;

    private String so2;

    private String time;

    private String createtime;

    private String main;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPm2() {
        return pm2;
    }

    public void setPm2(String pm2) {
        this.pm2 = pm2 == null ? null : pm2.trim();
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi == null ? null : aqi.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10 == null ? null : pm10.trim();
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co == null ? null : co.trim();
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2 == null ? null : no2.trim();
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3 == null ? null : o3.trim();
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2 == null ? null : so2.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main == null ? null : main.trim();
    }
}