package com.airmonitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airmonitor.mapper.TbBaseMapper;
import com.airmonitor.pojo.TbBase;
import com.airmonitor.service.BaseService;
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	TbBaseMapper tbBaseMapper;
	@Override
	public List<TbBase> findAll() {
		return tbBaseMapper.selectByExample(null);
	}
	@Override
	public TbBase findOne(Integer id) {
		return tbBaseMapper.selectByPrimaryKey(id);
	}

}
