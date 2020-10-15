package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.StockDataYKAnalysisDao;
import com.ts.module.crawler.service.STockDataYKAnalysisService;

@Service("STockDataYKAnalysisService")
public class StockDataYKAnalysisImpl implements STockDataYKAnalysisService{
	@Autowired
	private StockDataYKAnalysisDao stockDataYKAnalysisDao;

	@Override
	public int queryYKListCount() {
		// TODO Auto-generated method stub
		return stockDataYKAnalysisDao.queryYKListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryYKList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockDataYKAnalysisDao.queryYKList(map);
	}

	@Override
	public List<HashMap<String, Object>> queryZXList(HashMap<String, Object> map) {
		// public List<HashMap<String,Object>> queryZXList(HashMap<String,Object> map);
		return stockDataYKAnalysisDao.queryZXList(map);
	}
}
