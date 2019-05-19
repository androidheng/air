package com.airmonitor.service;
import java.util.List;
import com.airmonitor.pojo.TbParams;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ParamsService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbParams> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbParams params);
	
	
	/**
	 * 修改
	 */
	public void update(TbParams params);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbParams findOne(Integer id);
	
	
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
	public PageResult findPage(TbParams params, int pageNum,int pageSize);


	public TbParams find(Integer bid, Integer level);


	public List<TbParams> findBid(Integer bid);


	
}
