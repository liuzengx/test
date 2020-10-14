package com.ts.module.crawler.service;

import java.util.HashMap;
import java.util.List;

public interface STockDataYKAnalysisService {
	
	public int queryYKListCount();
	
	public List<HashMap<String,Object>> queryYKList(HashMap<String,Object> map);
}
