package com.wy.service.impl;

import com.wy.controller.LoginModel;
import com.wy.dao.VisitInfoMapper;
import com.wy.dao.UserInfoMapper;
import com.wy.model.VisitInfo;
import com.wy.model.VisitInfoExample;
import com.wy.model.UserInfo;
import com.wy.service.VisitInfoService;
import com.wy.service.VisitInfoService;
import com.wy.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class VisitInfoServiceImpl implements VisitInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    VisitInfoMapper visitInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      我要访客
    */
    @Override
    public String add(VisitInfo model, LoginModel login) {
        model.setIsDeal(1); //默认未处理,
        model.setUserId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        visitInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(VisitInfo model, LoginModel login) {
        VisitInfo preModel = visitInfoMapper.selectByPrimaryKey(model.getId());
        //preModel.getReplyContent(model.getReplyContent());
        visitInfoMapper.updateByPrimaryKey(model); //更新数据

        return "";
    }

    /**
      处理
    */
    @Override
    public String update3(VisitInfo model, LoginModel login) {
        VisitInfo preModel = visitInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setIsDeal(2); //是否已处理设置为已处理
        preModel.setReplyContent(model.getReplyContent());
        visitInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询访客列表数据
    */
    @Override
    public Map<String, Object> getDataList(VisitInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        VisitInfoExample se = new VisitInfoExample();
        VisitInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getVisitUser() != null) &&
                (queryModel.getVisitUser().equals("") == false)) {
            sc.andVisitUserLike("%" + queryModel.getVisitUser() +
                "%"); //模糊查询
        }

        if (queryModel.getIsDeal() != null) {
            sc.andIsDealEqualTo(queryModel.getIsDeal()); //查询是否已处理等于指定值
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        int count = (int) visitInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<VisitInfo> list = visitInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (VisitInfo model : list) {
            list2.add(getVisitInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装访客为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getVisitInfoModel(VisitInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("visitInfo", model);
        map.put("isDealStr", DataListUtils.getIsDealNameById(model.getIsDeal() + "")); //解释是否已处理字段

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //访客用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr", userInfo.getName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        visitInfoMapper.deleteByPrimaryKey(id);
    }
}

