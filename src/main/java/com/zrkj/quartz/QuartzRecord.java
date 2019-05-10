package com.zrkj.quartz;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbData;
import com.airmonitor.service.CityService;
import com.airmonitor.service.DataService;
import com.airmonitor.utils.DateUtils;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import entity.WeatherBean;
import entity.WeatherBean.HeWeather6Bean.AirNowCityBean;
 
public class QuartzRecord {
	@Autowired
	private CityService cityService;

	@Autowired
	private DataService dataService;
	
   /* public void execute(){
        System.out.println(new Date()+"定时执行任务");
    }*/
    //@RequestMapping(value="/cityMonitor",produces = "application/json;charset=UTF-8")
	public void execute(){
		RestTemplate  restTemplate=new RestTemplate();
		//TbUser user=(TbUser) session.getAttribute("user");
			Map<String, Object> map=new HashMap<>();
			List<TbCity> list = cityService.findAll();
			String createtime=DateUtils.getCurrent();
			for (TbCity tbCity : list) {
				String param = "key=0d81119269bf41afa341be808898f4f6&location="+tbCity.getCity();
				String url = "https://free-api.heweather.net/s6/air/now?"+param;
				
				String result = restTemplate.postForObject(url,JSON.toJSONString(map) , String.class);
				System.out.println("result:"+result);
				WeatherBean cityData = new Gson().fromJson(result, WeatherBean.class);
				AirNowCityBean air_now_city = cityData.getHeWeather6().get(0).getAir_now_city();
				//List<ResultBean> list = cityData.getResult();
				//for (ResultBean bean : list) {
				TbData tbData=new TbData();
				tbData.setAqi(air_now_city.getAqi());
				tbData.setCo(air_now_city.getCo());
				//tbData.setCity(air_now_city.getc);
				tbData.setNo2(air_now_city.getNo2());
				tbData.setO3(air_now_city.getO3());
				tbData.setPm10(air_now_city.getPm10());
				tbData.setPm2(air_now_city.getPm25());
				tbData.setSo2(air_now_city.getSo2());
				tbData.setTime(air_now_city.getPub_time());
				tbData.setQuality(air_now_city.getQlty());
				tbData.setCid(tbCity.getId());
				tbData.setCity(tbCity.getCity());
				tbData.setCreatetime(createtime);
				tbData.setMain(air_now_city.getMain());
				dataService.add(tbData);
			}
			
			
			//}
			//return result;		
		
		//return new Result(false, "未登录");		
	}
}
