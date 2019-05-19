package com.airmonitor.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmonitor.pojo.TbBase;
import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbData;
import com.airmonitor.pojo.TbParams;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.pojo.TbWarn;
import com.airmonitor.service.BaseService;
import com.airmonitor.service.CityService;
import com.airmonitor.service.ParamsService;
import com.airmonitor.service.WarnService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/warn")
public class WarnController {

	@Autowired
	private WarnService warnService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private ParamsService paramsService;
	@Autowired
	private CityService cityService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbWarn> findAll(){			
		return warnService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return warnService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param warn
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbWarn warn){
		TbBase tbBase = baseService.findOne(warn.getBid());
		warn.setBname(tbBase.getTypename());
		List<TbParams> list = paramsService.findBid(warn.getBid());
		int level=0;
		int pid=0;
		boolean flag = false;
		for (TbParams tbParams : list) {
			if(Double.parseDouble(tbParams.getStart())<=Double.parseDouble(warn.getNums())&&
					Double.parseDouble(tbParams.getEnd())>=Double.parseDouble(warn.getNums())) {
				level=tbParams.getLevel();
				pid=tbParams.getId();
				flag=true;
				break;
			}
		}
		if(!flag) {
			return new Result(false, "请先定义此参数的范围!");
		}
		TbCity tbCity = cityService.findOne(warn.getCid());
		warn.setLevels(level+"");
		warn.setPid(pid);
		warn.setCname(tbCity.getCity());
		if(StringUtils.isEmpty(warn.getId())) {
			try {
			warnService.add(warn);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			warnService.update(warn);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
		}
		
	}
	

	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOne")
	public TbWarn findOne(Integer id){
		return warnService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			warnService.delete(id);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param key
	 * @param page
	 * @param limit
	 * @return
	 */
	 @ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key, int page, int limit  ){
		TbWarn warn=new TbWarn();
		if(!StringUtils.isEmpty(key)) {
			warn.setPid(Integer.parseInt(key));
		}
		return warnService.findPage(warn, page, limit);		
	}
	   @ResponseBody
		@RequestMapping(value="/searchAir",produces = "application/json;charset=UTF-8")
		public Object searchAir(String date,HttpSession session,String cid){
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
				List<TbWarn> datas=warnService.findAirData(Integer.parseInt(searchId),date);
				Map<String, Object> resultMap=new HashMap<String, Object>();
				List<Map<String, Object>> resultList=new ArrayList<Map<String,Object>>();
				List<String> xAxisData=new ArrayList<String>();
				Map<String, Object> mp1=new HashMap<String, Object>();
				mp1.put("type", "line");
				List<Integer> pm2List=new ArrayList<Integer>();
				for(TbWarn d:datas){
					mp1.put("name",d.getBname());
					xAxisData.add(d.getCreatetime());
					pm2List.add(Integer.parseInt(d.getNums()));
				}
				mp1.put("data", pm2List);
				resultMap.put("data", xAxisData);
				resultList.add(mp1);
				resultMap.put("series", resultList);
				return resultMap;		
			}
			return new Result(false, "请先登录");
		}
	   @ResponseBody
		@RequestMapping(value="/searchAir2",produces = "application/json;charset=UTF-8")
		public PageResult searchAir2(String date,HttpSession session,String cid,int page,int limit){
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
				List<TbWarn> datas=warnService.findAirData(Integer.parseInt(searchId),date);
				PageResult result=new PageResult(0,"",datas.size(),datas);
				return result;		
			}
			return null;
		}
}
