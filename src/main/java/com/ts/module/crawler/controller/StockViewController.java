package com.ts.module.crawler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ts.module.crawler.service.STockDayPriceInfoService;
import com.ts.module.crawler.service.STockMoneyFlowInfoService;
import com.ts.module.utils.DbUtils;

/*股票信息类*/
@Controller
public class StockViewController {
	@Autowired
	private STockMoneyFlowInfoService stockMoneyFlowInfoService;
	@Autowired
	private STockDayPriceInfoService stockDayPriceInfoService;

	/*历史资金*/
	@RequestMapping("/showStockViewList.do")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/stockView/list";
	}
	/*当日价格走势*/
	@RequestMapping("/showStockDailyPriceList.do")
	public String stockdailypricelist(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/stockDayPrice/list";
	}
	/*获取历史资金List*/
	@RequestMapping(value = "crawler/stockView/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryStockViewList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String fdateq = request.getParameter("fdateq");
		String fdatez = request.getParameter("fdatez");
		String fCode = request.getParameter("fcode");
		String fName = request.getParameter("fname");

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int total = 0;

		try {
			int maxResult = DbUtils.generatePaginationMaxResult(page, pageSize);
			int firstResult = DbUtils.generatePaginationFirstResult(page, pageSize);
			map.put("firstResult", firstResult);
			map.put("maxResult", maxResult);
			map.put("fdateq", fdateq);
			map.put("fdatez", fdatez);
			map.put("fCode", fCode);
			map.put("fName", fName);
			
			list = stockMoneyFlowInfoService.queryList(map);
			total = stockMoneyFlowInfoService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}
	
	/*获取当日价格走势List*/
	@RequestMapping(value = "crawler/stockDayPrice/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryStockDayPriceList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String fdateq = request.getParameter("fdateq");
		String fdatez = request.getParameter("fdatez");
		String fCode = request.getParameter("fcode");
		String fName = request.getParameter("fname");

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int total = 0;

		try {
			int maxResult = DbUtils.generatePaginationMaxResult(page, pageSize);
			int firstResult = DbUtils.generatePaginationFirstResult(page, pageSize);
			map.put("firstResult", firstResult);
			map.put("maxResult", maxResult);
			map.put("fdateq", fdateq);
			map.put("fdatez", fdatez);
			map.put("fCode", fCode);
			map.put("fName", fName);
			list = stockDayPriceInfoService.queryList(map);
			total = stockDayPriceInfoService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}
	

}
