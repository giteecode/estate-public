package com.wy.service;

import com.wy.controller.LoginModel;
import com.wy.model.RepairInfo;

import java.util.Map;


public interface RepairInfoService {
    /**
      分页查询投诉数据列表
    */
    public Map<String, Object> getDataList(RepairInfo queryModel,Integer page, Integer pageSize, LoginModel login);

    /**
      封装投诉为前台展示的数据形式
    */
    public Map<String, Object> getRepairInfoModel(RepairInfo model,LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      我要投诉
    */
    public String add(RepairInfo model, LoginModel login);

    /**
      修改
    */
    public String update(RepairInfo model, LoginModel login);

    /**
      处理
    */
    public String update3(RepairInfo model, LoginModel login);
}

