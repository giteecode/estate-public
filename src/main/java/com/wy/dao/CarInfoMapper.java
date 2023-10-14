package com.wy.dao;

import com.wy.model.CarInfo;
import com.wy.model.CarInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoMapper {

    int countByExample(CarInfoExample example);


    int deleteByExample(CarInfoExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(CarInfo record);


    int insertSelective(CarInfo record);


    List<CarInfo> selectByExample(CarInfoExample example);


    CarInfo selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") CarInfo record, @Param("example") CarInfoExample example);


    int updateByExample(@Param("record") CarInfo record, @Param("example") CarInfoExample example);


    int updateByPrimaryKeySelective(CarInfo record);


    int updateByPrimaryKey(CarInfo record);
}