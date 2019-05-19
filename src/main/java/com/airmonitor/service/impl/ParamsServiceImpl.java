package com.airmonitor.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.airmonitor.mapper.TbParamsMapper;
import com.airmonitor.pojo.TbParams;
import com.airmonitor.pojo.TbParamsExample;
import com.airmonitor.pojo.TbParamsExample.Criteria;
import com.airmonitor.service.ParamsService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ParamsServiceImpl implements ParamsService {

	@Autowired
	private TbParamsMapper paramsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbParams> findAll() {
		return paramsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbParams> page=   (Page<TbParams>) paramsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbParams params) {
		paramsMapper.insert(params);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbParams params){
		paramsMapper.updateByPrimaryKeySelective(params);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbParams findOne(Integer id){
		return paramsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		paramsMapper.deleteByPrimaryKey(id);
			
	}
	
	
		@Override
	public PageResult findPage(TbParams params, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbParamsExample example=new TbParamsExample();
		Criteria criteria = example.createCriteria();
		
		if(params!=null){			
				
		}
		
		Page<TbParams> page= (Page<TbParams>)paramsMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public TbParams find(Integer bid, Integer level) {
			TbParamsExample example=new TbParamsExample();
			Criteria criteria = example.createCriteria();
			criteria.andBidEqualTo(bid);
			criteria.andLevelEqualTo(level);
			List<TbParams> list = paramsMapper.selectByExample(example);
			if(list.size()>0)
				return list.get(0);
			return null;
		}


		@Override
		public List<TbParams> findBid(Integer bid) {
			TbParamsExample example=new TbParamsExample();
			Criteria criteria = example.createCriteria();
			criteria.andBidEqualTo(bid);
			return  paramsMapper.selectByExample(example);
		}
	
}
