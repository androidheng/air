package entity;

import java.util.List;

/**
 * Created by ASUS on 2019/4/14.
 */

public class CityData {

    /**
     * resultcode : 200
     * reason : SUCCESSED!
     * result : [{"city":"南京","PM2.5":"21","AQI":"51","quality":"良","PM10":"52","CO":"0.0","NO2":"18","O3":"128","SO2":"11","time":"2019-04-14 17:35:18"}]
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * city : 南京
         * PM2.5 : 21
         * AQI : 51
         * quality : 良
         * PM10 : 52
         * CO : 0.0
         * NO2 : 18
         * O3 : 128
         * SO2 : 11
         * time : 2019-04-14 17:35:18
         */

        private String city;
        @com.google.gson.annotations.SerializedName("PM2.5")
        private String PM2; // FIXME check this code
        private String AQI;
        private String quality;
        private String PM10;
        private String CO;
        private String NO2;
        private String O3;
        private String SO2;
        private String time;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

       

        public String getPM2() {
			return PM2;
		}

		public void setPM2(String pM2) {
			PM2 = pM2;
		}

		public String getAQI() {
            return AQI;
        }

        public void setAQI(String AQI) {
            this.AQI = AQI;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getPM10() {
            return PM10;
        }

        public void setPM10(String PM10) {
            this.PM10 = PM10;
        }

        public String getCO() {
            return CO;
        }

        public void setCO(String CO) {
            this.CO = CO;
        }

        public String getNO2() {
            return NO2;
        }

        public void setNO2(String NO2) {
            this.NO2 = NO2;
        }

        public String getO3() {
            return O3;
        }

        public void setO3(String O3) {
            this.O3 = O3;
        }

        public String getSO2() {
            return SO2;
        }

        public void setSO2(String SO2) {
            this.SO2 = SO2;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

		@Override
		public String toString() {
			return "ResultBean [city=" + city + ", PM2=" + PM2 + ", AQI=" + AQI + ", quality=" + quality + ", PM10="
					+ PM10 + ", CO=" + CO + ", NO2=" + NO2 + ", O3=" + O3 + ", SO2=" + SO2 + ", time=" + time + "]";
		}

	
        
    }
}
