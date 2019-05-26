package com.airmonitor.mapper;

import com.airmonitor.pojo.TbData;
import com.airmonitor.pojo.TbDataExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TbDataMapper {
    int countByExample(TbDataExample example);

    int deleteByExample(TbDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbData record);

    int insertSelective(TbData record);

    List<TbData> selectByExample(TbDataExample example);

    TbData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbData record, @Param("example") TbDataExample example);

    int updateByExample(@Param("record") TbData record, @Param("example") TbDataExample example);

    int updateByPrimaryKeySelective(TbData record);

    int updateByPrimaryKey(TbData record);
    
    List<TbData> findAllByCid(@Param("cid") Integer cid,@Param("dates") String dates);
    
    List<TbData> findRealData(@Param("cid") Integer cid,@Param("dates") String dates);
    
    List<TbData> findHistoryData(@Param("cid") Integer cid,@Param("dates") String dates);
    
    List<TbData> findBingData(@Param("cid") Integer cid,@Param("dates") String dates);
    
    List<TbData> findZhuData(@Param("cid") Integer cid,@Param("dates") String dates);
    
    List<TbData> findDay(@Param("cid") Integer cid,@Param("date") String date);
    
    List<TbData> findMonth(@Param("cid") Integer cid,@Param("date") String date);
    
    List<TbData> findYear(@Param("cid") Integer cid,@Param("date") String date);

//    List<Map<String, Object>> findExcelRealData(@Param("cid") Integer cid,@Param("dates") String dates);
    
	List<Map<String, Object>> findDataObject();

	List<TbData> findHeadmap(@Param("dates") String dates);
}