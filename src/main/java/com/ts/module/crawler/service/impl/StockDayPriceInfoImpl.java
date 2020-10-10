package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.StockDayPriceInfoDao;
import com.ts.module.crawler.service.STockDayPriceInfoService;

@Service("STockDayPriceInfoService")
public class StockDayPriceInfoImpl implements STockDayPriceInfoService{
	@Autowired
	private StockDayPriceInfoDao stockDayPriceInfoDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return stockDayPriceInfoDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockDayPriceInfoDao.queryList(map);
	}

	@Override
	public int delete(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
}
