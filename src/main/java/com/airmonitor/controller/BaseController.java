package com.airmonitor.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airmonitor.pojo.TbBase;
import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.service.BaseService;
import com.airmonitor.service.CityService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/base")
public class BaseController { 

	@Autowired
	private BaseService baseService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBase> findAll(){			
		return baseService.findAll();
	}
	
	
}
