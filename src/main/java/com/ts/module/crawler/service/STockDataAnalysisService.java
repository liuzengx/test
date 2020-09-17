package com.ts.module.crawler.service;

import java.util.HashMap;
import java.util.List;

public interface STockDataAnalysisService {
	
	public int queryListCount();
	
	public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
}
