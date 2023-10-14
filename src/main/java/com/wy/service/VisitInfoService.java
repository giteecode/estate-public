package com.wy.service;

import com.wy.controller.LoginModel;
import com.wy.model.VisitInfo;

import java.util.Map;


public interface VisitInfoService {
    /**
      分页查询访客数据列表
    */
    public Map<String, Object> getDataList(VisitInfo queryModel, Integer page, Integer pageSize, LoginModel login);

    /**
      封装访客为前台展示的数据形式
    */
    public Map<String, Object> getVisitInfoModel(VisitInfo model,LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      我要访客
    */
    public String add(VisitInfo model, LoginModel login);

    /**
      修改
    */
    public String update(VisitInfo model, LoginModel login);

    /**
      处理
    */
    public String update3(VisitInfo model, LoginModel login);
}

