package com.airmonitor.service;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.airmonitor.pojo.TbData;

import entity.PageResult;
import entity.Result;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface DataService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbData> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbData data);
	
	
	/**
	 * 修改
	 */
	public void update(TbData data);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbData findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbData data, int pageNum,int pageSize);


	public Result findData(TbData data);


	public List<TbData> findAllByCid(Integer cid,String dates);


	public XSSFWorkbook exportExcelInfo();


	public List<TbData> findRealData(int cid, String dates);


	public XSSFWorkbook exportrealtime(int cid, String dates);


	public List<TbData> findHistoryData(int cid, String dates);


	public List<TbData> findBingData(int cid, String dates);


	public List<TbData> findZhuData(int cid, String dates);


	public PageResult baobiao(String type, Integer cid, String date,int page,int limit);


	public List<TbData> findHeadmap(String dates);
	
}
