package com.ts.module.crawler.dao;

import java.util.HashMap;
import java.util.List;

public interface StockDataYKAnalysisDao {
	
	public int queryYKListCount();
	
	public List<HashMap<String,Object>> queryYKList(HashMap<String,Object> map);
	
	public List<HashMap<String,Object>> queryZXList(HashMap<String,Object> map);
}
