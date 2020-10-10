package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.StockDataAnalysisDao;
import com.ts.module.crawler.service.STockDataAnalysisService;

@Service("STockDataAnalysisService")
public class StockDataAnalysisImpl implements STockDataAnalysisService{
	@Autowired
	private StockDataAnalysisDao stockDataAnalysisDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return stockDataAnalysisDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockDataAnalysisDao.queryList(map);
	}
}
