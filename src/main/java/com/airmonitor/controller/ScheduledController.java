package com.airmonitor.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
public class ScheduledController { 
	 @Scheduled(fixedRate = 5000)
	 public void cacheUpdate(){
		 System.out.println("五秒打印一次");
	}
}
