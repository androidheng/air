package com.airmonitor.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airmonitor.pojo.TbBase;
import com.airmonitor.pojo.TbParams;
import com.airmonitor.service.BaseService;
import com.airmonitor.service.ParamsService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/params")
public class ParamsController {

	@Autowired
	private ParamsService paramsService;
	@Autowired
	private BaseService baseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbParams> findAll(){			
		return paramsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return paramsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/addOrUpdate",produces = "application/json;charset=UTF-8")
	public Result addOrUpdate(@RequestBody TbParams params){
		if(StringUtils.isEmpty(params.getId())) {//添加
			try {
				TbParams hasParams=paramsService.find(params.getBid(),params.getLevel());
				if(hasParams!=null) {
					return new Result(false, "已经存在此级别的参数");
				}
				TbBase tbBase = baseService.findOne(params.getBid());
				params.setBname(tbBase.getTypename());
				paramsService.add(params);
				return new Result(true, "增加成功");
			} catch (Exception e) { 
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				paramsService.update(params);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
		
	}
	
	/**
	 * 修改
	 * @param params
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbParams params){
		try {
			paramsService.update(params);
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
	public TbParams findOne(Integer id){
		return paramsService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbParams params){
		try {
			paramsService.delete(params.getId());
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
	 * @param limit
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbParams params, int page, int limit  ){
		return paramsService.findPage(params, page, limit);		
	}
	
}
