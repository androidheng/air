package com.airmonitor.service;
import java.util.List;
import com.airmonitor.pojo.TbCity;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CityService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbCity> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbCity city);
	
	
	/**
	 * 修改
	 */
	public void update(TbCity city);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbCity findOne(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbCity city, int pageNum,int pageSize);


	public List<TbCity> findAllByUid(Integer cid);
	
}
