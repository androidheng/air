package com.airmonitor.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.service.CityService;
import com.airmonitor.service.UserService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CityService cityService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return userService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	public Result add(@RequestBody TbUser user){
		System.out.println(user.getId());
		TbCity tbCity = cityService.findOne(user.getCid());
		if(user.getId()==null) {
			try {
				user.setCname(tbCity.getCity());
				user.setType(0);
				userService.add(user);
				return new Result(true, "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "添加失败");
			}
		}else {
			try {
				user.setCname(tbCity.getCity());
				userService.update(user);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
	
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbUser user){
		try {
			userService.update(user);
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
	public TbUser findOne(Integer id){
		return userService.findOne(id);		
	}
	@RequestMapping("/login")
	public Result login(@RequestBody TbUser user,HttpSession session){
		TbUser tbUser = userService.findUser(user);
		if(tbUser!=null) {
			session.setAttribute("user", tbUser);
			return new Result(true, "登陆成功");
		}else {
			return new Result(false, "登陆失败");	
		}
			
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbUser user){
		try {
			userService.delete(user.getId());
			return new Result(true, "删除成功"); 
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
	public PageResult search(String key, int page, int limit  ){
		TbUser user=null;
		if(!StringUtils.isEmpty(key)) {
			user=new TbUser();
			user.setUsername(key);
		}
		PageResult result = userService.findPage(user, page, limit);
		return result;		
	}
	
}
