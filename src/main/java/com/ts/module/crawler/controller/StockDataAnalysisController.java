package com.ts.module.crawler.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.module.crawler.service.STockAnalysisReportService;
import com.ts.module.crawler.service.STockDataAnalysisService;
import com.ts.module.crawler.service.STockDataYKAnalysisService;
import com.ts.module.utils.DbUtils;

/*股票信息类*/
@Controller
public class StockDataAnalysisController {
	@Autowired
	private STockAnalysisReportService stockAnalysisReportService;
	@Autowired
	private STockDataAnalysisService stockDataAnalysisService;
	@Autowired
	private STockDataYKAnalysisService stockDataYKAnalysisService;

	/*数据分析*/
	@RequestMapping("/showStockDataAnalysisList.do")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/stockDataAnalysis/list";
	}
	/*分析画像*/
	@RequestMapping("/showStockDataYKAnalysisList.do")
	public String showStockDataYKAnalysisList(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);

		return "crawler/stockDataYKAnalysis/list";
	}
	/*数据分析报告*/
	@RequestMapping("/showStockAnalysisReportList.do")
	public String analysisList(HttpServletRequest request, HttpServletResponse response, Model model) {
		// model.addAttribute("sessions", sessions);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		HashMap<String, Object> map = new HashMap<String, Object>();
//		String jcAjxxUuid = request.getParameter("jcAjxxUuid");
		map.put("fdateq", null);
		map.put("fdatez", null);
		map.put("fCode", 300188);
		map.put("fName", null);
		
		try {
			int jyrCount = stockAnalysisReportService.queryJyrCount(map);
			hm.put("jyrCount", jyrCount);
			String dateQj = stockAnalysisReportService.queryDateQj(map);
			hm.put("dateQj", dateQj);
			int zsyCount = stockAnalysisReportService.queryZsyCount(map);
			hm.put("zsyCount", zsyCount);
			double f1 = new BigDecimal((float)zsyCount/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
			String zsyScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zsyScale", zsyScale);
			int fsyCount = stockAnalysisReportService.queryFsyCount(map);
			hm.put("fsyCount", fsyCount);
			f1 = new BigDecimal((float)fsyCount/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String fsyScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("fsyScale", fsyScale);
			//负收益时，亏转盈数量；
			int fsyKzyCount = stockAnalysisReportService.queryFsy_KzyCount(map);
			hm.put("fsyKzyCount", fsyKzyCount);
			f1 = new BigDecimal((float)fsyKzyCount/fsyCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String fsyKzyScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("fsyKzyScale", fsyKzyScale);
			int wsyCount = stockAnalysisReportService.queryWsyCount(map);
			hm.put("wsyCount", wsyCount);
			f1 = new BigDecimal((float)wsyCount/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String wsyScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("wsyScale", wsyScale);
			//今收盘>今最低
			int spjDyZdjCount = stockAnalysisReportService.querySpjDyZdjCount(map);
			hm.put("spjDyZdjCount", spjDyZdjCount);
			f1 = new BigDecimal((float)spjDyZdjCount/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String spjDyZdjScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("spjDyZdjScale", spjDyZdjScale);
			//今收盘=今最低
			int spjDdyZdjCount = stockAnalysisReportService.querySpjDdyZdjCount(map);
			hm.put("spjDdyZdjCount", spjDdyZdjCount);
			f1 = new BigDecimal((float)spjDdyZdjCount/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String spjDdyZdjScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("spjDdyZdjScale", spjDdyZdjScale);
			
			//(0.00<=(今高-今开))
			int zgj_Kpj_0_00Count = stockAnalysisReportService.queryZgj_Kpj_0_00Count(map);
			hm.put("zgj_Kpj_0_00Count", zgj_Kpj_0_00Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_00Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_00CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_00CountScale", zgj_Kpj_0_00CountScale);
			//(0.05<=(今高-今开))
			int zgj_Kpj_0_05Count = stockAnalysisReportService.queryZgj_Kpj_0_05Count(map);
			hm.put("zgj_Kpj_0_05Count", zgj_Kpj_0_05Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_05Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_05CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_05CountScale", zgj_Kpj_0_05CountScale);
			//(0.10<=(今高-今开))
			int zgj_Kpj_0_10Count = stockAnalysisReportService.queryZgj_Kpj_0_10Count(map);
			hm.put("zgj_Kpj_0_10Count", zgj_Kpj_0_10Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_10Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_10CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_10CountScale", zgj_Kpj_0_10CountScale);
			//(0.15<=(今高-今开))
			int zgj_Kpj_0_15Count = stockAnalysisReportService.queryZgj_Kpj_0_15Count(map);
			hm.put("zgj_Kpj_0_15Count", zgj_Kpj_0_15Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_15Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_15CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_15CountScale", zgj_Kpj_0_15CountScale);
			//(0.20<=(今高-今开))
			int zgj_Kpj_0_20Count = stockAnalysisReportService.queryZgj_Kpj_0_20Count(map);
			hm.put("zgj_Kpj_0_20Count", zgj_Kpj_0_20Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_20Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_20CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_20CountScale", zgj_Kpj_0_20CountScale);
			//(0.25<=(今高-今开))
			int zgj_Kpj_0_25Count = stockAnalysisReportService.queryZgj_Kpj_0_25Count(map);
			hm.put("zgj_Kpj_0_25Count", zgj_Kpj_0_25Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_25Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_25CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_25CountScale", zgj_Kpj_0_25CountScale);
			//(0.30<=(今高-今开))
			int zgj_Kpj_0_30Count = stockAnalysisReportService.queryZgj_Kpj_0_30Count(map);
			hm.put("zgj_Kpj_0_30Count", zgj_Kpj_0_30Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_30Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_30CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_30CountScale", zgj_Kpj_0_30CountScale);
			//(0.35<=(今高-今开))
			int zgj_Kpj_0_35Count = stockAnalysisReportService.queryZgj_Kpj_0_35Count(map);
			hm.put("zgj_Kpj_0_35Count", zgj_Kpj_0_35Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_35Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_35CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_35CountScale", zgj_Kpj_0_35CountScale);
			//(0.40<=(今高-今开))
			int zgj_Kpj_0_40Count = stockAnalysisReportService.queryZgj_Kpj_0_40Count(map);
			hm.put("zgj_Kpj_0_40Count", zgj_Kpj_0_40Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_40Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_40CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_40CountScale", zgj_Kpj_0_40CountScale);
			//(0.45<=(今高-今开))
			int zgj_Kpj_0_45Count = stockAnalysisReportService.queryZgj_Kpj_0_45Count(map);
			hm.put("zgj_Kpj_0_45Count", zgj_Kpj_0_45Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_45Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_45CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_45CountScale", zgj_Kpj_0_45CountScale);
			//(0.50<=(今高-今开))
			int zgj_Kpj_0_50Count = stockAnalysisReportService.queryZgj_Kpj_0_50Count(map);
			hm.put("zgj_Kpj_0_50Count", zgj_Kpj_0_50Count);
			f1 = new BigDecimal((float)zgj_Kpj_0_50Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String zgj_Kpj_0_50CountScale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("zgj_Kpj_0_50CountScale", zgj_Kpj_0_50CountScale);
			//(0.00=(今开-今低))
			int kpj_Zdj_0_00Count = stockAnalysisReportService.queryKpj_Zdj_0_00Count(map);
			hm.put("kpj_Zdj_0_00Count", kpj_Zdj_0_00Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_00Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_00Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_00Scale", kpj_Zdj_0_00Scale);
			//(0.05=<(今开-今低))
			int kpj_Zdj_0_05Count = stockAnalysisReportService.queryKpj_Zdj_0_05Count(map);
			hm.put("kpj_Zdj_0_05Count", kpj_Zdj_0_05Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_05Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_05Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_05Scale", kpj_Zdj_0_05Scale);
			//(0.10=<(今开-今低))
			int kpj_Zdj_0_10Count = stockAnalysisReportService.queryKpj_Zdj_0_10Count(map);
			hm.put("kpj_Zdj_0_10Count", kpj_Zdj_0_10Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_10Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_10Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_10Scale", kpj_Zdj_0_10Scale);
			//(0.15=<(今开-今低))
			int kpj_Zdj_0_15Count = stockAnalysisReportService.queryKpj_Zdj_0_15Count(map);
			hm.put("kpj_Zdj_0_15Count", kpj_Zdj_0_15Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_15Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_15Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_15Scale", kpj_Zdj_0_15Scale);
			//(0.20=<(今开-今低))
			int kpj_Zdj_0_20Count = stockAnalysisReportService.queryKpj_Zdj_0_20Count(map);
			hm.put("kpj_Zdj_0_20Count", kpj_Zdj_0_20Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_20Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_20Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_20Scale", kpj_Zdj_0_20Scale);
			//(0.25=<(今开-今低))
			int kpj_Zdj_0_25Count = stockAnalysisReportService.queryKpj_Zdj_0_25Count(map);
			hm.put("kpj_Zdj_0_25Count", kpj_Zdj_0_25Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_25Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_25Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_25Scale", kpj_Zdj_0_25Scale);
			//(0.30=<(今开-今低))
			int kpj_Zdj_0_30Count = stockAnalysisReportService.queryKpj_Zdj_0_30Count(map);
			hm.put("kpj_Zdj_0_30Count", kpj_Zdj_0_30Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_30Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_30Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_30Scale", kpj_Zdj_0_30Scale);
			//(0.35=<(今开-今低))
			int kpj_Zdj_0_35Count = stockAnalysisReportService.queryKpj_Zdj_0_35Count(map);
			hm.put("kpj_Zdj_0_35Count", kpj_Zdj_0_35Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_35Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_35Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_35Scale", kpj_Zdj_0_35Scale);
			//(0.40=<(今开-今低))
			int kpj_Zdj_0_40Count = stockAnalysisReportService.queryKpj_Zdj_0_40Count(map);
			hm.put("kpj_Zdj_0_40Count", kpj_Zdj_0_40Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_40Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_40Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_40Scale", kpj_Zdj_0_40Scale);
			//(0.45=<(今开-今低))
			int kpj_Zdj_0_45Count = stockAnalysisReportService.queryKpj_Zdj_0_45Count(map);
			hm.put("kpj_Zdj_0_45Count", kpj_Zdj_0_45Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_45Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_45Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_45Scale", kpj_Zdj_0_45Scale);
			//(0.50=<(今开-今低))
			int kpj_Zdj_0_50Count = stockAnalysisReportService.queryKpj_Zdj_0_50Count(map);
			hm.put("kpj_Zdj_0_50Count", kpj_Zdj_0_50Count);
			f1 = new BigDecimal((float)kpj_Zdj_0_50Count/jyrCount).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			df = new DecimalFormat("0.00");//格式化小数  
			String kpj_Zdj_0_50Scale = df.format((float)f1*100)+"%";//返回的是String类型
			hm.put("kpj_Zdj_0_50Scale", kpj_Zdj_0_50Scale);
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	/*获取数据分析画像List*/
	@RequestMapping(value = "crawler/stockDataYKAnalysis/getList.do")
	@ResponseBody
	public HashMap<String, Object> queryStockDataYKAnalysisList(HttpServletRequest request, HttpServletResponse response) {
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
			map.put("order", 1);
			
			list = stockDataYKAnalysisService.queryYKList(map);
			total = stockDataYKAnalysisService.queryYKListCount();

		} catch (Exception e) {
			System.out.println("ttt::" + e);
		}

		result.put("rows", list);
		result.put("total", total);

		return result;
	}
	//数据分析画像收益对比柱形图
    @RequestMapping(value = "crawler/stockDataYKAnalysis/getBarData.do")
    @ResponseBody
    public HashMap<String, Object> BarData (HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam(value = "arg1", required = true) int arg1,
                                    @RequestParam(value = "arg2", required = true) int arg2,
                                    @RequestParam(value = "fCode", required = true) String fCode,
                                    @RequestParam(value = "fName", required = true) String fName
                                    ) throws Exception {
    	// 结果集合
        HashMap<String, Object> result = new HashMap<String, Object>();
        HashMap<String, Object> map = new HashMap<String, Object>();
    	 try{
    		 	//查询参数
    		 map.put("fCode", fCode);
    		 map.put("fName", fName);
    		 
                  List<Double> data1 =new ArrayList<Double>();//
                  
                  List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
                  list = stockDataYKAnalysisService.queryZXList(map);
                  
                  HashMap<String, Object> item=null;
                  double temp=0.0D;
                  double temp1=0.0D;
                  double temp2=0.0D;
                  double temp3=0.0D;
                  double temp4=0.0D;
                  double temp5=0.0D;
                  double temp6=0.0D;
                  for (int i = 0; i < list.size(); i ++) {
                      item = list.get(i);
                      temp = Double.parseDouble(item.get("ybgztsy").toString().replace(",", ""));
                      temp1 = Double.parseDouble(item.get("wbgztsy").toString().replace(",", ""));
                      temp2 = Double.parseDouble(item.get("1qgztsy").toString().replace(",", ""));
                      temp3 = Double.parseDouble(item.get("2qgztsy").toString().replace(",", ""));
                      temp4 = Double.parseDouble(item.get("3qgztsy").toString().replace(",", ""));
                      temp5 = Double.parseDouble(item.get("4qgztsy").toString().replace(",", ""));
                      temp6 = Double.parseDouble(item.get("5qgztsy").toString().replace(",", ""));
                      
                        data1.add(temp);
                        data1.add(temp1);
                        data1.add(temp2);
                        data1.add(temp3);
                        data1.add(temp4);
                        data1.add(temp5);
                        data1.add(temp6);
                      }
                  
                    result.put("data1", data1);
                  return result;
              } catch (Exception ex) {
              	System.out.println(ex);
              }finally {
      			
      		}
    	 return result;
         }
	//数据分析画像收益对比折线图
    @RequestMapping(value = "crawler/stockDataYKAnalysis/getLineData.do")
    @ResponseBody
    public HashMap<String, Object> groupTop10 (HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam(value = "arg1", required = true) int arg1,
                                    @RequestParam(value = "arg2", required = true) int arg2,
                                    @RequestParam(value = "fCode", required = true) String fCode,
                                    @RequestParam(value = "fName", required = true) String fName
                                    ) throws Exception {
    	// 结果集合
        HashMap<String, Object> result = new HashMap<String, Object>();
        HashMap<String, Object> map = new HashMap<String, Object>();
    	 try{
    		 	//查询参数
    		 map.put("fCode", fCode);
    		 map.put("fName", fName);
    		 map.put("order", 2);
    		 
                  List<String> dataName =new ArrayList<String>();
                  List<String> dataDate =new ArrayList<String>();//日期
                  List<Double> data1 =new ArrayList<Double>();//
                  List<Double> data2 =new ArrayList<Double>();//
                  List<Double> data3 =new ArrayList<Double>();//
                  List<Double> data4 =new ArrayList<Double>();//
                  List<Double> data5 =new ArrayList<Double>();//
                  List<Double> data6 =new ArrayList<Double>();//
                  
                  List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
                  list = stockDataYKAnalysisService.queryYKList(map);
                  
                  HashMap<String, Object> item=null;
                  String name="";
                  double value = 0.0D;
                  double temp=0.0D;
                  double temp2=0.0D;
                  double temp3=0.0D;
                  double temp4=0.0D;
                  double temp5=0.0D;
                  double temp6=0.0D;
                  for (int i = 0; i < list.size(); i ++) {
                      item = list.get(i);
                      name = item.get("fdate").toString();
                      //temp = item.get("1qgztsy");
                      temp = Double.parseDouble(item.get("wbgztsy").toString().replace(",", ""));
                      temp2 = Double.parseDouble(item.get("1qgztsy").toString().replace(",", ""));
                      temp3 = Double.parseDouble(item.get("2qgztsy").toString().replace(",", ""));
                      temp4 = Double.parseDouble(item.get("3qgztsy").toString().replace(",", ""));
                      temp5 = Double.parseDouble(item.get("4qgztsy").toString().replace(",", ""));
                      temp6 = Double.parseDouble(item.get("5qgztsy").toString().replace(",", ""));
                      //value = new BigDecimal(temp / 10000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                      	dataDate.add(name);
                        data1.add(temp);
                        data2.add(temp2);
                        data3.add(temp3);
                        data4.add(temp4);
                        data5.add(temp5);
                        data6.add(temp6);
                      }
                  
                    result.put("dataName", dataName);
                    result.put("dataDate", dataDate);
                    result.put("data1", data1);
                    result.put("data2", data2);
                    result.put("data3", data3);
                    result.put("data4", data4);
                    result.put("data5", data5);
                    result.put("data6", data6);
                  return result;
              } catch (Exception ex) {
              	System.out.println(ex);
              }finally {
      			
      		}
    	 return result;
         }
   
	

}
