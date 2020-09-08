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
import com.ts.module.crawler.service.CRawlerCronJobService;
import com.ts.module.crawler.service.CRawlerUrlTaskService;
import com.ts.module.utils.DbUtils;

/*爬虫管理类*/
@Controller
public class CrawlerController {
	@Autowired
	private CRawlerUrlTaskService crawlerUrlTaskService;
	@Autowired
	private CRawlerCronJobService crawlerCronJobService;
	

	/*任务列表*/
	@RequestMapping("/showCrawlerTaskList.do")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/crawlerTask/list";
	}
	/*定时任务*/
	@RequestMapping("/showCrawlerCronJobList.do")
	public String stockdailypricelist(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/crawlerCronJob/list";
	}
	/*获取任务列表List*/
	@RequestMapping(value = "crawler/crawlerTask/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryCrawlerTaskList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int total = 0;

		try {
			int maxResult = DbUtils.generatePaginationMaxResult(page, pageSize);
			int firstResult = DbUtils.generatePaginationFirstResult(page, pageSize);
			map.put("firstResult", firstResult);
			map.put("maxResult", maxResult);
			list = crawlerUrlTaskService.queryList(map);
			total = crawlerUrlTaskService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}
	
	/*获取定时任务List*/
	@RequestMapping(value = "crawler/crawlerCronJob/getList.do")
	@ResponseBody
	public HashMap<String, Object> querycrawlerCronJobList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int total = 0;

		try {
			int maxResult = DbUtils.generatePaginationMaxResult(page, pageSize);
			int firstResult = DbUtils.generatePaginationFirstResult(page, pageSize);
			map.put("firstResult", firstResult);
			map.put("maxResult", maxResult);
			list = crawlerCronJobService.queryList(map);
			total = crawlerCronJobService.queryListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}


}
