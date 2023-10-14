package com.wy.controller.user;

import com.wy.controller.LoginModel;

import com.wy.dao.*;

import com.wy.model.*;

import com.wy.service.*;
import com.wy.service.impl.*;

import com.wy.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/user_info")
public class UUserInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
    进入用户详情页
    */
    @RequestMapping("detail")
    public Object detail(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
        UserInfo model = new UserInfo();
        model.setId(login.getId());

        Map<String, Object> rs = userInfoService.getDataList(null, model, null,
                null, login);
        List<Map<String, Object>> tmplist = (List<Map<String, Object>>) rs.get(
                "list");

        if ((tmplist != null) && (tmplist.size() > 0)) {
            modelMap.addAttribute("detail", tmplist.get(0));
        } else {
            modelMap.addAttribute("detail", new HashMap<String, Object>());
        }

        return "user/personal";
    }

    /**
     修改提交信息接口
     */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(UserInfo model, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = userInfoService.update(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                    "修改成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     进入修改页面
     */
    @RequestMapping("update")
    public String update(ModelMap modelMap, UserInfo model, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号
        UserInfo data = userInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "user/person_update_page";
    }
}

