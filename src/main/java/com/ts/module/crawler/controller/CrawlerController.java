package com.ts.module.crawler.controller;

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

/*爬虫管理类*/
@Controller
public class CrawlerController {
	@Autowired
	private STockProfitService stockProfitService;

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


}
