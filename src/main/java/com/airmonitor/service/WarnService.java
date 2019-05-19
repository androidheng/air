package com.airmonitor.service;
import java.util.List;
import com.airmonitor.pojo.TbWarn;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface WarnService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbWarn> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbWarn warn);
	
	
	/**
	 * 修改
	 */
	public void update(TbWarn warn);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbWarn findOne(Integer id);
	
	
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
	public PageResult findPage(TbWarn warn, int pageNum,int pageSize);


	public List<TbWarn> findAirData(int parseInt, String date);
	
}
