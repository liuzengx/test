package com.ts.module.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.module.system.service.UserService;
import com.ts.module.utils.ModUtil;
import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("sys_user_queryList.do")
	public String queryList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "system/userManage/list";
	}

	/*@RequestMapping("/system/userManage/listEdit.do")
	public String listEdit(HttpServletRequest request, HttpServletResponse response) {

		return "system/userManage/listEdit";
	}*/

	@RequestMapping(value = "system/userManage/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryUserList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int page = Integer.parseInt(request.getParameter("offset"));
		int pageSize = Integer.parseInt(request.getParameter("limit"));
		int total = 0;

		map.put("page", page);
		map.put("pageSize", pageSize);
		try {
			list = userService.queryList(map);
			total = userService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}

	// 新增
	@RequestMapping(value = "system/userManage/addRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> addRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// HashMap<String,Object> map = SysJson.toHashMap(code);
		// SysResult sysResult = userDao.add(map);
		JSONObject js = ModUtil.strToJson(jsonStr);
		
		 map.put("addDate","2019-02-19"); map.put("md5","125");
		 
		Date date = new Date();
		String dateToStr = ModUtil.dateToString(date);
		js.put("addDate", dateToStr);
		map = ModUtil.JsontoMap(js);
		try {
			userService.addUser(map);
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

	// 修改
	@RequestMapping(value = "system/userManage/editRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> editRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// HashMap<String,Object> map = SysJson.toHashMap(code);
		// SysResult sysResult = userDao.add(map);
		JSONObject js = ModUtil.strToJson(jsonStr);
		
		 map.put("addDate","2019-02-19"); map.put("md5","125");
		 
		// Date date=new Date();
		// String dateToStr = ModUtil.dateToString(date);
		// js.put("addDate",dateToStr);
		// js.put("md5", ModUtil.Md5(js.get("stockCode")+dateToStr));
		map = ModUtil.JsontoMap(js);
		try {
			userService.updateUser(map);
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

	// 批量刪除
	@RequestMapping(value = "system/userManage/delRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<HashMap<String, Object>> jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		//JSONObject js = ModUtil.strToMap(jsonStr);
		List<HashMap<String, Object>> jsonSr=jsonStr;
		
		
		//json转换为map
		//map = ModUtil.JsontoMap(js);
		try {
			for (int i = 0; i < jsonSr.size(); i++) {
				HashMap<String,Object> hashMap = jsonSr.get(i);
				//userService.deleteUser(hashMap);
			}
			
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

}
