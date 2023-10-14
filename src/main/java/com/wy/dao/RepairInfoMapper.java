package com.wy.dao;

import com.wy.model.RepairInfo;
import com.wy.model.RepairInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairInfoMapper {

    int countByExample(RepairInfoExample example);


    int deleteByExample(RepairInfoExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(RepairInfo record);


    int insertSelective(RepairInfo record);


    List<RepairInfo> selectByExample(RepairInfoExample example);


    RepairInfo selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") RepairInfo record, @Param("example") RepairInfoExample example);


    int updateByExample(@Param("record") RepairInfo record, @Param("example") RepairInfoExample example);


    int updateByPrimaryKeySelective(RepairInfo record);


    int updateByPrimaryKey(RepairInfo record);
}