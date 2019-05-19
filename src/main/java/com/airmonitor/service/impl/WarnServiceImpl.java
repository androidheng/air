package com.airmonitor.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.airmonitor.mapper.TbWarnMapper;
import com.airmonitor.pojo.TbWarn;
import com.airmonitor.pojo.TbWarnExample;
import com.airmonitor.pojo.TbWarnExample.Criteria;
import com.airmonitor.service.WarnService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class WarnServiceImpl implements WarnService {

	@Autowired
	private TbWarnMapper warnMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbWarn> findAll() {
		return warnMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbWarn> page=   (Page<TbWarn>) warnMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbWarn warn) {
		warnMapper.insert(warn);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbWarn warn){
		warnMapper.updateByPrimaryKeySelective(warn);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbWarn findOne(Integer id){
		return warnMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		warnMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbWarn warn, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbWarnExample example=new TbWarnExample();
		Criteria criteria = example.createCriteria();
		
		if(warn!=null){			
			if(!StringUtils.isEmpty(warn.getPid())) {
				criteria.andPidEqualTo(warn.getPid());
			}
		}
		
		Page<TbWarn> page= (Page<TbWarn>)warnMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbWarn> findAirData(int cid, String date) {
			
			return warnMapper.findAirData(cid,date);
		}
	
}
