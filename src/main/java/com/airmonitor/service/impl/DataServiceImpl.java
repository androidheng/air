package com.airmonitor.service.impl;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.airmonitor.mapper.TbDataMapper;
import com.airmonitor.pojo.TbData;
import com.airmonitor.pojo.TbDataExample;
import com.airmonitor.pojo.TbDataExample.Criteria;
import com.airmonitor.service.DataService;
import com.airmonitor.utils.ExcelBean;
import com.airmonitor.utils.ExcelUtil;

import entity.CityData;
import entity.PageResult;
import entity.Result;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private TbDataMapper dataMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbData> findAll() {
		return dataMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbData> page=   (Page<TbData>) dataMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbData data) {
		dataMapper.insert(data);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbData data){
		dataMapper.updateByPrimaryKey(data);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbData findOne(Integer id){
		return dataMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			dataMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbData data, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbDataExample example=new TbDataExample();
		Criteria criteria = example.createCriteria();
		
		if(data!=null){			
				
		}
		
		Page<TbData> page= (Page<TbData>)dataMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public Result findData(TbData data) {
			TbDataExample example=new TbDataExample();
			Criteria criteria = example.createCriteria();
			
			if(data!=null){			
				if(data.getCid()!=null) {
					criteria.andCidEqualTo(data.getCid());
				}	
			}
			return new Result(true, dataMapper.selectByExample(example));
		}

		@Override
		public List<TbData> findAllByCid(Integer cid,String dates) {
			return dataMapper.findAllByCid(cid,dates);
		}

		@Override
		public XSSFWorkbook exportExcelInfo()  {
			//根据条件查询数据
			List<Map<String,Object>> list = dataMapper.findDataObject();
			//System.out.println(list);
			List<ExcelBean> excel = new ArrayList<>();
			Map<Integer,List<ExcelBean>> map = new LinkedHashMap<>();
			//设置标题栏
			excel.add(new ExcelBean("pm2","pm2",0));
			excel.add(new ExcelBean("aqi", "aqi", 0));
			excel.add(new ExcelBean("quality","quality",0));
			excel.add(new ExcelBean("pm10","pm10",0));
			excel.add(new ExcelBean("co","co", 0));
			excel.add(new ExcelBean("no2","no2",0));
			excel.add(new ExcelBean("so2","so2",0));
			map.put(0,excel);
			String sheetName = "用户信息表";
			//调用ExcelUtil方法
			XSSFWorkbook xssfWorkbook = null;
			try {
				xssfWorkbook = ExcelUtil.createExcelFile(CityData.class, list, map, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(xssfWorkbook);
			return xssfWorkbook;
		}

		@Override
		public List<TbData> findRealData(int cid, String dates) {
			return dataMapper.findRealData(cid,dates);
		}

		@Override
		public XSSFWorkbook exportrealtime(int cid, String dates) {
			return null;
		}

		@Override
		public List<TbData> findHistoryData(int cid, String dates) {
			return dataMapper.findHistoryData(cid, dates);
		}

		@Override
		public List<TbData> findBingData(int cid, String dates) {
			// TODO Auto-generated method stub
			return dataMapper.findBingData(cid, dates);
		}

		@Override
		public List<TbData> findZhuData(int cid, String dates) {
			return dataMapper.findZhuData(cid, dates);
		}

		@Override
		public PageResult baobiao(String type, String cid, String date,int pageNum,int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			if(type.equals("0")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findDay(Integer.parseInt(cid), date);
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else if(type.equals("1")) {
				Page<TbData> page= (Page<TbData>)dataMapper.findMonth(Integer.parseInt(cid), date);
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}else{
				Page<TbData> page= (Page<TbData>)dataMapper.findYear(Integer.parseInt(cid), date);
				return new PageResult(0,"",page.getTotal(), page.getResult());
			}
		}

		@Override
		public List<TbData> findHeadmap(String dates) {
			
			return dataMapper.findHeadmap(dates);
		}
	
}
