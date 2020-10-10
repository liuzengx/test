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
import com.ts.module.crawler.service.STockDataAnalysisService;
import com.ts.module.utils.DbUtils;

/*股票信息类*/
@Controller
public class StockDataAnalysisController {
	@Autowired
	private STockDataAnalysisService stockDataAnalysisService;

	/*数据分析*/
	@RequestMapping("/showStockDataAnalysisList.do")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/stockDataAnalysis/list";
	}
	/*数据分析报告*/
	@RequestMapping("/showStockAnalysisReportList.do")
	public String analysisList(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
//		String jcAjxxUuid = request.getParameter("jcAjxxUuid");
		map.put("firstResult", 1);
		map.put("maxResult", 1);
		map.put("fdateq", null);
		map.put("fdatez", null);
		map.put("fCode", 300188);
		map.put("fName", null);
		
//        List<HashMap<String, Object>> list = InspectQueryService.getDetail(jcAjxxUuid);
		List<HashMap<String, Object>> list = stockDataAnalysisService.queryList(map);
        if (list != null && list.size() > 0) {
            hm = list.iterator().next();
        }
        model.addAttribute("hm", hm);

		return "crawler/stockAnalysisReport/list";
	}
	/*获取数据分析List*/
	@RequestMapping(value = "crawler/stockDataAnalysis/getList.do")
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
			
			list = stockDataAnalysisService.queryList(map);
			total = stockDataAnalysisService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}
	

}
