package com.airmonitor.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.airmonitor.mapper.TbCityMapper;
import com.airmonitor.pojo.TbCity;
import com.airmonitor.pojo.TbCityExample;
import com.airmonitor.pojo.TbCityExample.Criteria;
import com.airmonitor.service.CityService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private TbCityMapper cityMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbCity> findAll() {
		return cityMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCity> page=   (Page<TbCity>) cityMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCity city) {
		cityMapper.insert(city);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbCity city){
		cityMapper.updateByPrimaryKey(city);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbCity findOne(Integer id){
		return cityMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
		cityMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbCity city, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCityExample example=new TbCityExample();
		Criteria criteria = example.createCriteria();
		
		if(city!=null){			
			if(city.getCity()!=null) {
				criteria.andCityLike("%"+city.getCity()+"%");
			}	
		}
		
		Page<TbCity> page= (Page<TbCity>)cityMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbCity> findAllByUid(Integer cid) {
			TbCityExample example=new TbCityExample();
			Criteria criteria = example.createCriteria();
			
			criteria.andIdEqualTo(cid);
			return cityMapper.selectByExample(example);
		}
	
}
