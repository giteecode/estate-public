package com.wy.service;

import com.wy.controller.LoginModel;
import com.wy.model.CarInfo;

import java.util.Map;


public interface CarInfoService {
    /**
      分页查询车位数据列表
    */
    public Map<String, Object> getDataList(CarInfo queryModel,Integer page, Integer pageSize, LoginModel login);

    /**
      封装车位为前台展示的数据形式
    */
    public Map<String, Object> getCarInfoModel(CarInfo model,LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(CarInfo model, LoginModel login);

    /**
      修改
    */
    public String update(CarInfo model, LoginModel login);
}

