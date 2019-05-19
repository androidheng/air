package com.airmonitor.service;
import java.util.List;

import com.airmonitor.pojo.TbBase;
import com.airmonitor.pojo.TbCity;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface BaseService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbBase> findAll();
	
	public TbBase findOne(Integer id);
	
	
}
