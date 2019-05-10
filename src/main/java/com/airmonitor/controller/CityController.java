package com.airmonitor.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.service.CityService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/city")
public class CityController { 

	@Autowired
	private CityService cityService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbCity> findAll(){			
		return cityService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return cityService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param city
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	public Result add(@RequestBody TbCity city){
		if(city.getId()==null) {
			try {
				cityService.add(city);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				cityService.update(city);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
	
	}
	
	/**
	 * 修改
	 * @param city
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbCity city){
		try {
			cityService.update(city);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbCity findOne(Integer id){
		return cityService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbCity city){
		try {
			cityService.delete(city.getId());
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@RequestMapping("/myCity")
	public Result myCity(HttpSession session){
		try {
			TbUser user =(TbUser)session.getAttribute("user");
			if(user!=null) {
				if(user.getType()!=0) {
					List<TbCity> list=cityService.findAll();
					return new Result(true, list); 
				}else {
					List<TbCity> list=cityService.findAllByUid(user.getCid());
					return new Result(true, list);
				}
				
			}
		
			return new Result(false, "未登录"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbCity city=null;
		if(!StringUtils.isEmpty(key)) {
			city=new TbCity();
			city.setCity(key);
		}
		return cityService.findPage(city, page, limit);		
	}
	@RequestMapping("/findCity")
	public Result findCity(HttpSession session){
		try {
			TbUser user=(TbUser) session.getAttribute("user");
			if(user!=null){
				if(user.getType()==1){
					return new Result(true,cityService.findAll());
				}else{
					return new Result(true,cityService.findAllByUid(user.getCid()));
				}
			}
			return new Result(false, "未登录");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
}
