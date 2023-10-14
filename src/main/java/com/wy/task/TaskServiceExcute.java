package com.wy.task;
import java.util.Map;
import java.util.HashMap;
import com.wy.controller.LoginModel;
import com.wy.model.*;
import com.wy.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.wy.service.*;
import  java.io.InputStream;
import   java.text.SimpleDateFormat;
import  com.wy.util.*;
import   org.springframework.ui.ModelMap;
import   java.util.regex.Pattern;
import  java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
@Component 
public class TaskServiceExcute {
@Autowired
TaskService taskService;
//更新车位状态和用户车位费用,定时规则：每分钟执行一次
 @Scheduled(cron="0 0/1 * * * ?")  
public void updateData(){
	taskService.updateData();
}
}
