package com.wy.service.impl;

import com.wy.controller.LoginModel;
import com.wy.dao.RepairInfoMapper;
import com.wy.dao.RepairInfoMapper;
import com.wy.dao.UserInfoMapper;
import com.wy.model.RepairInfo;
import com.wy.model.RepairInfoExample;
import com.wy.model.RepairInfo;
import com.wy.model.RepairInfoExample;
import com.wy.model.UserInfo;
import com.wy.service.RepairInfoService;
import com.wy.service.RepairInfoService;
import com.wy.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class RepairInfoServiceImpl implements RepairInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    RepairInfoMapper repairInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      我要报修
    */
    @Override
    public String add(RepairInfo model, LoginModel login) {
        model.setIsDeal(1); //默认未处理,
        model.setUserId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        repairInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(RepairInfo model, LoginModel login) {
        RepairInfo preModel = repairInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setRepairContent(model.getRepairContent());
        repairInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
      处理
    */
    @Override
    public String update3(RepairInfo model, LoginModel login) {
        RepairInfo preModel = repairInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setIsDeal(2); //是否已处理设置为已处理
        preModel.setReplyContent(model.getReplyContent());
        repairInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询报修列表数据
    */
    @Override
    public Map<String, Object> getDataList(RepairInfo queryModel,Integer page, Integer pageSize, LoginModel login) {
        RepairInfoExample se = new RepairInfoExample();
        RepairInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getRepairContent() != null) &&
                (queryModel.getRepairContent().equals("") == false)) {
            sc.andRepairContentLike("%" + queryModel.getRepairContent() +
                "%"); //模糊查询
        }

        if (queryModel.getIsDeal() != null) {
            sc.andIsDealEqualTo(queryModel.getIsDeal()); //查询是否已处理等于指定值
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        int count = (int) repairInfoMapper.countByExample(se);
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

        List<RepairInfo> list = repairInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (RepairInfo model : list) {
            list2.add(getRepairInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装报修为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getRepairInfoModel(RepairInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repairInfo", model);
        map.put("isDealStr",
            DataListUtils.getIsDealNameById(model.getIsDeal() + "")); //解释是否已处理字段

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //报修用户为外接字段,需要关联用户来解释该字段

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
        repairInfoMapper.deleteByPrimaryKey(id);
    }
}

