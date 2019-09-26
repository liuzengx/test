package com.ts.module.stock.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ts.module.stock.service.STockProfitService;
import com.ts.module.system.model.User;
import com.ts.module.utils.ModUtil;
import net.sf.json.JSONObject;

@Controller
public class StockController {
	@Autowired
	private STockProfitService stockProfitService;

	@RequestMapping("/showStockList.do")
	public String list1(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "stock/profit/list";
	}

	@RequestMapping("/showTan.do")
	public String list1(HttpServletRequest request, HttpServletResponse response) {

		return "stock/profit/tan";
	}

	@RequestMapping("/showListEdit.do")
	public String listEdit(HttpServletRequest request, HttpServletResponse response) {

		return "stock/profit/listEdit";
	}

	@RequestMapping(value = "stock/profit/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryStockProfitList22(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();

		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		String userId = String.valueOf(user.getUserId());
		String account = user.getAccount();

		int page = Integer.parseInt(request.getParameter("offset"));
		int pageSize = Integer.parseInt(request.getParameter("limit"));
		int total = 0;

		map.put("page", page);
		map.put("pageSize", pageSize);
		try {
			list = stockProfitService.queryList(map);
			total = stockProfitService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}

	// 新增
	@RequestMapping(value = "stock/profit/addRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> addRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// HashMap<String,Object> map = SysJson.toHashMap(code);
		// SysResult sysResult = userDao.add(map);
		JSONObject js = ModUtil.strToJson(jsonStr);
		/*
		 * map.put("addDate","2019-02-19"); map.put("md5","125");
		 */
		Date date = new Date();
		String dateToStr = ModUtil.dateToString(date);
		js.put("addDate", dateToStr);
		js.put("md5", ModUtil.Md5(js.get("stockCode") + dateToStr));
		map = ModUtil.JsontoMap(js);
		try {
			stockProfitService.addStockProfit(map);
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

	// 修改
	@RequestMapping(value = "stock/profit/editRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> editRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// HashMap<String,Object> map = SysJson.toHashMap(code);
		// SysResult sysResult = userDao.add(map);
		JSONObject js = ModUtil.strToJson(jsonStr);
		/*
		 * map.put("addDate","2019-02-19"); map.put("md5","125");
		 */
		// Date date=new Date();
		// String dateToStr = ModUtil.dateToString(date);
		// js.put("addDate",dateToStr);
		// js.put("md5", ModUtil.Md5(js.get("stockCode")+dateToStr));
		map = ModUtil.JsontoMap(js);
		try {
			stockProfitService.updateStockProfit(map);
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

	// 批量刪除
	@RequestMapping(value = "stock/profit/delRecord.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delRecord(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String jsonStr) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject js = ModUtil.strToJson(jsonStr);
		//json转换为map
		map = ModUtil.JsontoMap(js);
		try {
			stockProfitService.deleteStockProfit(map);
			result.put("rows", "success");
		} catch (Exception e) {
			result.put("rows", e);
			e.printStackTrace();
		}
		return result;
	}

}
