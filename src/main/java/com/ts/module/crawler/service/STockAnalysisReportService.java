package com.ts.module.crawler.service;

import java.util.HashMap;
import java.util.List;

public interface STockAnalysisReportService {
	
	public int queryJyrCount(HashMap<String,Object> map);
	
	public String queryDateQj(HashMap<String,Object> map);
	
	public int queryZsyCount(HashMap<String,Object> map);
	
	public int queryFsyCount(HashMap<String,Object> map);
	
	//负收益时候，亏转盈的数量
	public int queryFsy_KzyCount(HashMap<String,Object> map);
	
	public int queryWsyCount(HashMap<String,Object> map);
	
	public int querySpjDyZdjCount(HashMap<String,Object> map);
	
	public int querySpjDdyZdjCount(HashMap<String,Object> map);
	
	//(0.00<=(今高-今开))
	public int queryZgj_Kpj_0_00Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_05Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_10Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_15Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_20Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_25Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_30Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_35Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_40Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_45Count(HashMap<String,Object> map);
	
	public int queryZgj_Kpj_0_50Count(HashMap<String,Object> map);
	//(0.00=(今开-今低))
	public int queryKpj_Zdj_0_00Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_05Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_10Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_15Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_20Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_25Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_30Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_35Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_40Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_45Count(HashMap<String,Object> map);
	
	public int queryKpj_Zdj_0_50Count(HashMap<String,Object> map);
	
	//public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
}
