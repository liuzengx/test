package com.ts.module.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.module.system.model.User;
import com.ts.module.system.service.SSessionLogService;

@Controller
public class UserManageController {
	@Autowired
	private SSessionLogService sSessionLogService;
	
	@RequestMapping("/showUserManageList.do")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        //model.addAttribute("sessions", sessions);
		
        return "system/userManage/list";
    }
	
	@RequestMapping(value = "system/userManage/getList.do")
    @ResponseBody
    public HashMap<String, Object> queryList (HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		String userId = String.valueOf(user.getUserId());
		String account = user.getAccount();
		
        int page = Integer.parseInt(request.getParameter("offset"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        int total=0;
        if(account.equals("admin")){
        	total = sSessionLogService.querySessionLogByUserID(map).size();
        	map.put("page", page);
    		map.put("pageSize", pageSize);
    		list =  sSessionLogService.querySessionLogByUserID(map);
        }else{
        	total = sSessionLogService.querySessionLogListCount(userId);
        	map.put("userId", userId);
    		map.put("page", page);
    		map.put("pageSize", pageSize);
    		list =  sSessionLogService.querySessionLogByUserID(map);
        }
        
		result.put("rows", list);
		result.put("total", total);

        return result;
    }
}
