package com.ts.module.crawler.dao;

import java.util.HashMap;
import java.util.List;

public interface StockDataAnalysisDao {
	
	public int queryListCount();
	
	public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
}
