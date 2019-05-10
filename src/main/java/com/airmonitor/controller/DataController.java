package com.airmonitor.controller;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airmonitor.pojo.TbData;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.service.BaseService;
import com.airmonitor.service.CityService;
import com.airmonitor.service.DataService;
import com.airmonitor.utils.DateUtils;
import com.airmonitor.utils.ExcelBean;
import com.airmonitor.utils.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import entity.CityData;
import entity.CityData.ResultBean;
import entity.PageResult;
import entity.Result;
import entity.WeatherBean;
import entity.WeatherBean.HeWeather6Bean.AirNowCityBean;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DataService dataService;
	@Autowired
	private CityService cityService;
	@Autowired
	private BaseService baseService;
	

	/**
	 * 数据监控
	 * @param city
	 * @param session
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/cityMonitor",produces = "application/json;charset=UTF-8")
	public Object cityMonitor(String city,HttpSession session,String cid){
		String dates=DateUtils.getCurrentDay();
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		RestTemplate  restTemplate=new RestTemplate();
		//TbUser user=(TbUser) session.getAttribute("user");
		if(user!=null){
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
			if(StringUtils.isEmpty(city)) {
				city=cityService.findOne(Integer.parseInt(cid)).getCity();
			}
			Map<String, Object> map=new HashMap<>();
			String param = "key=0d81119269bf41afa341be808898f4f6&location="+city;
			String url = "https://free-api.heweather.net/s6/air/now?"+param;
			
			String result = restTemplate.postForObject(url,JSON.toJSONString(map) , String.class);
			System.out.println("result:"+result);
			WeatherBean cityData = new Gson().fromJson(result, WeatherBean.class);
			AirNowCityBean air_now_city = cityData.getHeWeather6().get(0).getAir_now_city();
			return air_now_city;		
		}
		
		return new Result(false, "未登录");		
	}
	
	/**
	 * 实时数据折线图
	 * @param session
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/realtime",produces = "application/json;charset=UTF-8")
	public Object realtime(HttpSession session,String cid,String type){
		String dates=DateUtils.getCurrentDay();
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){ 
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
			
			List<TbData> datas=dataService.findRealData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xAxisData=new ArrayList<String>();
			List<String> legendData=new ArrayList<String>();
			Map<String, Object> mp1=new HashMap<String, Object>();
			mp1.put("name", "PM2.5");
			mp1.put("type", "line");
			//mp1.put("stack", "总量");
			List<Integer> pm2List=new ArrayList<Integer>();
			Map<String, Object> mp2=new HashMap<String, Object>();
			mp2.put("name", "PM10");
			mp2.put("type", "line");
			//mp2.put("stack", "总量");
			List<Integer> pm10List=new ArrayList<Integer>();
			Map<String, Object> mp3=new HashMap<String, Object>();
			mp3.put("name", "SO2");
			mp3.put("type", "line");
			//mp3.put("stack", "总量");
			List<Integer> so2List=new ArrayList<Integer>();
			Map<String, Object> mp4=new HashMap<String, Object>();
			mp4.put("name", "CO");
			mp4.put("type", "line");
			//mp4.put("stack", "总量");
			List<Double> coList=new ArrayList<Double>();
			Map<String, Object> mp5=new HashMap<String, Object>();
			mp5.put("name", "NO2");
			mp5.put("type", "line");
			//mp5.put("stack", "总量");
			List<Integer> no2List=new ArrayList<Integer>();
			
			Map<String, Object> mp6=new HashMap<String, Object>();
			mp6.put("name", "O3");
			mp6.put("type", "line");
			//mp6.put("stack", "总量");
			List<Integer> o3List=new ArrayList<Integer>();
			for(TbData d:datas){
				xAxisData.add(d.getCreatetime());
				pm2List.add(Integer.parseInt(d.getPm2()));
				pm10List.add(Integer.parseInt(d.getPm10()));
				so2List.add(Integer.parseInt(d.getSo2()));
				coList.add(Double.parseDouble(d.getCo()));
				no2List.add(Integer.parseInt(d.getNo2()));
				o3List.add(Integer.parseInt(d.getO3()));
			}
			mp1.put("data", pm2List);
			mp2.put("data", pm10List);
			mp3.put("data", so2List);
			mp4.put("data", coList);
			mp5.put("data", no2List);
			mp6.put("data", o3List);
			if(type.equals("1")) {
				resultList.add(mp1);
			}else if(type.equals("2")) {
				resultList.add(mp2);
			}else if(type.equals("3")) {
				resultList.add(mp3);
			}else if(type.equals("4")) {
				resultList.add(mp4);
			}else if(type.equals("5")) {
				resultList.add(mp5);
			}else if(type.equals("6")) {
				resultList.add(mp6);
			}
			
			
			
			
			
			
			resultMap.put("data", xAxisData);
			resultMap.put("series", resultList);
			return resultMap;		
		}
		return new Result(false, "请先登录");
	}
	/**
	 * 实时数据底部数据
	 * @param session
	 * @param cid
	 * @param type
	 * @param page
	 * @param limit
	 * @param dates
	 * @return
	 */
	@RequestMapping("/realtimesearch")
	public PageResult realtimesearch(HttpSession session,String cid,String type, int page, int limit,String dates  ){
		PageResult result=new PageResult();
		List<Map<String,Object>> lists=new ArrayList<>();
		if(StringUtils.isEmpty(dates))
		  dates=DateUtils.getCurrentDay();
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){ 
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
			
			List<TbData> datas=dataService.findRealData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xAxisData=new ArrayList<String>();
			List<String> legendData=new ArrayList<String>();
			Map<String, Object> mp1=new HashMap<String, Object>();
			mp1.put("name", "PM2.5");
			mp1.put("type", "line");
			//mp1.put("stack", "总量");
			List<Integer> pm2List=new ArrayList<Integer>();
			Map<String, Object> mp2=new HashMap<String, Object>();
			mp2.put("name", "PM10");
			mp2.put("type", "line");
			//mp2.put("stack", "总量");
			List<Integer> pm10List=new ArrayList<Integer>();
			Map<String, Object> mp3=new HashMap<String, Object>();
			mp3.put("name", "SO2");
			mp3.put("type", "line");
			//mp3.put("stack", "总量");
			List<Integer> so2List=new ArrayList<Integer>();
			Map<String, Object> mp4=new HashMap<String, Object>();
			mp4.put("name", "CO");
			mp4.put("type", "line");
			//mp4.put("stack", "总量");
			List<Double> coList=new ArrayList<Double>();
			Map<String, Object> mp5=new HashMap<String, Object>();
			mp5.put("name", "NO2");
			mp5.put("type", "line");
			//mp5.put("stack", "总量");
			List<Integer> no2List=new ArrayList<Integer>();
			
			Map<String, Object> mp6=new HashMap<String, Object>();
			mp6.put("name", "O3");
			mp6.put("type", "line");
			//mp6.put("stack", "总量");
			List<Integer> o3List=new ArrayList<Integer>();
			for(TbData d:datas){
				Map<String, Object> map=new HashMap<>();
				map.put("id", type);
				map.put("name", "pm2.5");
				if(type.equals("1")) {
					map.put("nums", d.getPm2());
				}else if(type.equals("2")) {
					map.put("nums", d.getPm10());
				}else if(type.equals("3")) {
					map.put("nums", d.getSo2());
				}else if(type.equals("4")) {
					map.put("nums", d.getCo());
				}else if(type.equals("5")) {
					map.put("nums", d.getNo2());
				}else if(type.equals("6")) {
					map.put("nums", d.getO3());
				}
				map.put("createtime", d.getCreatetime());
				lists.add(map);
			}
			result.setCount(lists.size());
			result.setData(lists);
			result.setCode(0);
			result.setMsg("");
			return result;		
		}
		return result;		
	}
	/**
	 * 导出实时数据
	 * @param request
	 * @param response
	 * @param session
	 * @param cid
	 * @param type
	 * @throws Exception
	 */
	@RequestMapping("/exportrealtime")
	@ResponseBody
	public void exportrealtime(HttpServletRequest request,HttpServletResponse response,HttpSession session,String cid,String type) throws Exception{
		String dates=DateUtils.getCurrentDay();
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){ 
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}
			
			PageResult result = realtimesearch(session, cid, type, 1, 15,dates);
			//根据条件查询数据
			List<Map<String,Object>> list = result.getData();
			//System.out.println(list);
			List<ExcelBean> excel = new ArrayList<>();
			Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
			//设置标题栏
			excel.add(new ExcelBean("编号","id",0));
			if(type.equals("1")) {
				excel.add(new ExcelBean("名称","name",0));
			}/*else if(type.equals("2")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("3")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("4")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("5")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("6")) {
				excel.add(new ExcelBean("名称","name",0));
			}*/
			excel.add(new ExcelBean("数值","nums",0));
			excel.add(new ExcelBean("时间","createtime",0));
			map.put(0,excel);
			String sheetName = "实时数据信息";
			//调用ExcelUtil方法
			XSSFWorkbook xssfWorkbook = null;
			try {
				xssfWorkbook = ExcelUtil.createExcelFile(CityData.class, list, map, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(xssfWorkbook);
			
			
			
			response.reset(); //清除buffer缓存  
	        //Map<String,Object> map=new HashMap<String,Object>();  
	        // 指定下载的文件名  
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        String name=System.currentTimeMillis()+"";
	        response.setHeader("Content-Disposition","attachment;filename="+new String((name+".xlsx").getBytes(),"iso-8859-1"));
	        //导出Excel对象  
	        XSSFWorkbook workbook = xssfWorkbook;
	        OutputStream output;  
	        try {  
	            output = response.getOutputStream();  
	            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	            bufferedOutput.flush();  
	            workbook.write(bufferedOutput);  
	            bufferedOutput.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
		}   
		
	}
	
	@RequestMapping(value="/searchHistory",produces = "application/json;charset=UTF-8")
	public Object searchHistory(String dates,HttpSession session,String cid,String type){
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
				
			List<TbData> datas=dataService.findHistoryData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xAxisData=new ArrayList<String>();
			List<String> legendData=new ArrayList<String>();
			Map<String, Object> mp1=new HashMap<String, Object>();
			mp1.put("name", "PM2.5");
			mp1.put("type", "line");
			//mp1.put("stack", "总量");
			List<Integer> pm2List=new ArrayList<Integer>();
			Map<String, Object> mp2=new HashMap<String, Object>();
			mp2.put("name", "PM10");
			mp2.put("type", "line");
			//mp2.put("stack", "总量");
			List<Integer> pm10List=new ArrayList<Integer>();
			Map<String, Object> mp3=new HashMap<String, Object>();
			mp3.put("name", "SO2");
			mp3.put("type", "line");
			//mp3.put("stack", "总量");
			List<Integer> so2List=new ArrayList<Integer>();
			Map<String, Object> mp4=new HashMap<String, Object>();
			mp4.put("name", "CO");
			mp4.put("type", "line");
			//mp4.put("stack", "总量");
			List<Double> coList=new ArrayList<Double>();
			Map<String, Object> mp5=new HashMap<String, Object>();
			mp5.put("name", "NO2");
			mp5.put("type", "line");
			//mp5.put("stack", "总量");
			List<Integer> no2List=new ArrayList<Integer>();
			
			Map<String, Object> mp6=new HashMap<String, Object>();
			mp6.put("name", "O3");
			mp6.put("type", "line");
			//mp6.put("stack", "总量");
			List<Integer> o3List=new ArrayList<Integer>();
			for(TbData d:datas){
				xAxisData.add(d.getCreatetime());
				pm2List.add(Integer.parseInt(d.getPm2()));
				pm10List.add(Integer.parseInt(d.getPm10()));
				so2List.add(Integer.parseInt(d.getSo2()));
				coList.add(Double.parseDouble(d.getCo()));
				no2List.add(Integer.parseInt(d.getNo2()));
				o3List.add(Integer.parseInt(d.getO3()));
			}
			mp1.put("data", pm2List);
			mp2.put("data", pm10List);
			mp3.put("data", so2List);
			mp4.put("data", coList);
			mp5.put("data", no2List);
			mp6.put("data", o3List);
			if(type.equals("1")) {
				resultList.add(mp1);
			}else if(type.equals("2")) {
				resultList.add(mp2);
			}else if(type.equals("3")) {
				resultList.add(mp3);
			}else if(type.equals("4")) {
				resultList.add(mp4);
			}else if(type.equals("5")) {
				resultList.add(mp5);
			}else if(type.equals("6")) {
				resultList.add(mp6);
			}
			resultMap.put("data", xAxisData);
			resultMap.put("series", resultList);
			return resultMap;		
		}
		return new Result(false, "请先登录");
	}
	@RequestMapping("/exporthistory")
	@ResponseBody
	public void exporthistory(HttpServletRequest request,HttpServletResponse response,HttpSession session,String cid,String type,String dates) throws Exception{
		List<Map<String,Object>> lists=new ArrayList<>();
		if(StringUtils.isEmpty(dates))
		  dates=DateUtils.getCurrentDay();
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){ 
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
			
			List<TbData> datas=dataService.findHistoryData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xAxisData=new ArrayList<String>();
			List<String> legendData=new ArrayList<String>();
			Map<String, Object> mp1=new HashMap<String, Object>();
			mp1.put("name", "PM2.5");
			mp1.put("type", "line");
			//mp1.put("stack", "总量");
			List<Integer> pm2List=new ArrayList<Integer>();
			Map<String, Object> mp2=new HashMap<String, Object>();
			mp2.put("name", "PM10");
			mp2.put("type", "line");
			//mp2.put("stack", "总量");
			List<Integer> pm10List=new ArrayList<Integer>();
			Map<String, Object> mp3=new HashMap<String, Object>();
			mp3.put("name", "SO2");
			mp3.put("type", "line");
			//mp3.put("stack", "总量");
			List<Integer> so2List=new ArrayList<Integer>();
			Map<String, Object> mp4=new HashMap<String, Object>();
			mp4.put("name", "CO");
			mp4.put("type", "line");
			//mp4.put("stack", "总量");
			List<Double> coList=new ArrayList<Double>();
			Map<String, Object> mp5=new HashMap<String, Object>();
			mp5.put("name", "NO2");
			mp5.put("type", "line");
			//mp5.put("stack", "总量");
			List<Integer> no2List=new ArrayList<Integer>();
			
			Map<String, Object> mp6=new HashMap<String, Object>();
			mp6.put("name", "O3");
			mp6.put("type", "line");
			//mp6.put("stack", "总量");
			List<Integer> o3List=new ArrayList<Integer>();
			for(TbData d:datas){
				Map<String, Object> map=new HashMap<>();
				map.put("id", type);
				map.put("name", "pm2.5");
				if(type.equals("1")) {
					map.put("nums", d.getPm2());
				}else if(type.equals("2")) {
					map.put("nums", d.getPm10());
				}else if(type.equals("3")) {
					map.put("nums", d.getSo2());
				}else if(type.equals("4")) {
					map.put("nums", d.getCo());
				}else if(type.equals("5")) {
					map.put("nums", d.getNo2());
				}else if(type.equals("6")) {
					map.put("nums", d.getO3());
				}
				map.put("createtime", d.getCreatetime());
				lists.add(map);
			}
		
			List<ExcelBean> excel = new ArrayList<>();
			Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
			//设置标题栏
			excel.add(new ExcelBean("编号","id",0));
			if(type.equals("1")) {
				excel.add(new ExcelBean("名称","name",0));
			}/*else if(type.equals("2")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("3")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("4")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("5")) {
				excel.add(new ExcelBean("名称","name",0));
			}else if(type.equals("6")) {
				excel.add(new ExcelBean("名称","name",0));
			}*/
			excel.add(new ExcelBean("数值","nums",0));
			excel.add(new ExcelBean("时间","createtime",0));
			map.put(0,excel);
			String sheetName = dates+"数据信息";
			//调用ExcelUtil方法
			XSSFWorkbook xssfWorkbook = null;
			try {
				xssfWorkbook = ExcelUtil.createExcelFile(CityData.class, lists, map, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(xssfWorkbook);
			
			
			
			response.reset(); //清除buffer缓存  
			//Map<String,Object> map=new HashMap<String,Object>();  
			// 指定下载的文件名  
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
			String name=System.currentTimeMillis()+"";
			response.setHeader("Content-Disposition","attachment;filename="+new String((name+".xlsx").getBytes(),"iso-8859-1"));
			//导出Excel对象  
			XSSFWorkbook workbook = xssfWorkbook;
			OutputStream output;  
			try {  
				output = response.getOutputStream();  
				BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
				bufferedOutput.flush();  
				workbook.write(bufferedOutput);  
				bufferedOutput.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}
		}   
		
	}
	@RequestMapping("/findBingData")
	public Object findBingData(String cid,String dates,HttpSession session) {
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
				
			List<TbData> datas=dataService.findBingData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			for(TbData d:datas){
				Map<String, Object> map1=new HashMap<>();
				map1.put("value", d.getPm2());
				map1.put("name", "PM2.5");
				resultList.add(map1);
				Map<String, Object> map2=new HashMap<>();
				map2.put("value", d.getPm10());
				map2.put("name", "PM10");
				resultList.add(map2);
				Map<String, Object> map3=new HashMap<>();
				map3.put("value", d.getCo());
				map3.put("name", "Co");
				resultList.add(map3);
				Map<String, Object> map4=new HashMap<>();
				map4.put("value", d.getNo2());
				map4.put("name", "NO2");
				resultList.add(map4);
				Map<String, Object> map5=new HashMap<>();
				map5.put("value", d.getO3());
				map5.put("name", "O3");
				resultList.add(map5);
				Map<String, Object> map6=new HashMap<>();
				map6.put("value", d.getSo2());
				map6.put("name", "SO2");
				resultList.add(map6);
			}
			resultMap.put("data", resultList);
			return resultMap;		
		}
		return "no login";
	}
	@RequestMapping("/findZhuData")
	public Object findZhuData(String cid,String dates,HttpSession session,String type) {
		TbUser user=(TbUser) session.getAttribute("user");
		user=new TbUser();
		user.setType(1);
		String searchId;
		if(user!=null){
			if(user.getType()==0) {
				searchId=user.getCid()+"";
			}else {
				searchId=cid;
			}	
			
			List<TbData> datas=dataService.findZhuData(Integer.parseInt(searchId),dates);
			Map<String, Object> resultMap=new HashMap<String, Object>();
			List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
			List<String> xDatas=new ArrayList<>(); 
			List<String> mDatas=new ArrayList<>();
			for(TbData d:datas){
				xDatas.add(d.getCreatetime());
				if(type.equals("1")) {
					mDatas.add(d.getPm2());
				}else if(type.equals("2")) {
					mDatas.add(d.getPm10());
				}else if(type.equals("3")) {
					mDatas.add(d.getSo2());
				}else if(type.equals("4")) {
					mDatas.add(d.getCo());
				}else if(type.equals("5")) {
					mDatas.add(d.getNo2());
				}else if(type.equals("6")) {
					mDatas.add(d.getO3());
				}
			}
			resultMap.put("data", mDatas);
			resultMap.put("xdata", xDatas);
			return resultMap;		
		}
		return "no login";
	}
	@RequestMapping("/export")
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
	        response.reset(); //清除buffer缓存  
	        //Map<String,Object> map=new HashMap<String,Object>();  
	        // 指定下载的文件名  
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        response.setHeader("Content-Disposition","attachment;filename="+new String("2019.xlsx".getBytes(),"iso-8859-1"));
	        //导出Excel对象  
	        XSSFWorkbook workbook = dataService.exportExcelInfo();
	        OutputStream output;  
	        try {  
	            output = response.getOutputStream();  
	            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
	            bufferedOutput.flush();  
	            workbook.write(bufferedOutput);  
	            bufferedOutput.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
	}
}
