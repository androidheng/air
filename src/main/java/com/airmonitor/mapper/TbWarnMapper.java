package com.airmonitor.mapper;

import com.airmonitor.pojo.TbWarn;
import com.airmonitor.pojo.TbWarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWarnMapper {
    int countByExample(TbWarnExample example);

    int deleteByExample(TbWarnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbWarn record);

    int insertSelective(TbWarn record);

    List<TbWarn> selectByExample(TbWarnExample example);

    TbWarn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbWarn record, @Param("example") TbWarnExample example);

    int updateByExample(@Param("record") TbWarn record, @Param("example") TbWarnExample example);

    int updateByPrimaryKeySelective(TbWarn record);

    int updateByPrimaryKey(TbWarn record);

	List<TbWarn> findAirData(@Param("cid") int cid,@Param("date") String date);
}