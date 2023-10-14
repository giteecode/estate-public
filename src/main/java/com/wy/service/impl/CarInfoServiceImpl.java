package com.wy.service.impl;

import com.wy.controller.LoginModel;
import com.wy.dao.CarInfoMapper;
import com.wy.model.CarInfo;
import com.wy.model.CarInfoExample;
import com.wy.service.CarInfoService;
import com.wy.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CarInfoServiceImpl implements CarInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    CarInfoMapper carInfoMapper;

    /**
      新增
    */
    @Override
    public String add(CarInfo model, LoginModel login) {
        String check = checkData(model, 1); //检查数据是否符合要求

        if (check.equals("") == false) {
            return check;
        }
        //model.setIsUsed(1); //默认闲置中,
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        carInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(CarInfo model, LoginModel login) {
        CarInfo preModel = carInfoMapper.selectByPrimaryKey(model.getId());
//        String check1 = checkData(model, 2); //检查数据是否合法
//
//        if (check1.equals("") == false) {
//            return check1;
//        }

//        preModel.setCarNo(model.getCarNo());
//        preModel.setCarImg(model.getCarImg());
//        preModel.setAddress(model.getAddress());
        carInfoMapper.updateByPrimaryKey(model); //更新数据

        return "";
    }

    /**
    *根据参数查询车位列表数据
    */
    @Override
    public Map<String, Object> getDataList(CarInfo queryModel,Integer page, Integer pageSize, LoginModel login) {
        CarInfoExample se = new CarInfoExample();
        CarInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getCarNo() != null) &&
                (queryModel.getCarNo().equals("") == false)) {
            sc.andCarNoLike("%" + queryModel.getCarNo() + "%"); //模糊查询
        }

//        if (queryModel.getIsUsed() != null) {
//            sc.andIsUsedEqualTo(queryModel.getIsUsed()); //查询使用状态等于指定值
//        }

        int count = (int) carInfoMapper.countByExample(se);
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

        List<CarInfo> list = carInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CarInfo model : list) {
            list2.add(getCarInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装车位为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getCarInfoModel(CarInfo model,LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("carInfo", model);
//        map.put("isUsedStr",
//            DataListUtils.getIsUsedNameById(model.getIsUsed() + "")); //解释使用状态字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        carInfoMapper.deleteByPrimaryKey(id);
    }

    public String checkData(CarInfo model, Integer type) { //type=1 表示新增操作,type=2 表示修改操作,

        if ((type == 1) || (type == 2)) {
//            if (model.getCarImg() != null) {
//                String[] fileSplit = model.getCarImg().split(";");
//
//                if (fileSplit.length > 1) {
//                    return "车位图的图片数量不能大于1";
//                }
//            }
        }

        return "";
    }
}

