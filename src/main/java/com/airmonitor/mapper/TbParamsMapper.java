package com.airmonitor.mapper;

import com.airmonitor.pojo.TbParams;
import com.airmonitor.pojo.TbParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParamsMapper {
    int countByExample(TbParamsExample example);

    int deleteByExample(TbParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbParams record);

    int insertSelective(TbParams record);

    List<TbParams> selectByExample(TbParamsExample example);

    TbParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbParams record, @Param("example") TbParamsExample example);

    int updateByExample(@Param("record") TbParams record, @Param("example") TbParamsExample example);

    int updateByPrimaryKeySelective(TbParams record);

    int updateByPrimaryKey(TbParams record);
}