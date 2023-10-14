package com.wy.dao;

import com.wy.model.VisitInfo;
import com.wy.model.VisitInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitInfoMapper {

    int countByExample(VisitInfoExample example);


    int deleteByExample(VisitInfoExample example);


    int deleteByPrimaryKey(Integer id);


    int insert(VisitInfo record);


    int insertSelective(VisitInfo record);


    List<VisitInfo> selectByExample(VisitInfoExample example);


    VisitInfo selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") VisitInfo record, @Param("example") VisitInfoExample example);


    int updateByExample(@Param("record") VisitInfo record, @Param("example") VisitInfoExample example);


    int updateByPrimaryKeySelective(VisitInfo record);


    int updateByPrimaryKey(VisitInfo record);
}