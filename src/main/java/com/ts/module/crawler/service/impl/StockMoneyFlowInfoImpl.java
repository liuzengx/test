package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.StockMoneyFlowInfoDao;
import com.ts.module.crawler.service.STockMoneyFlowInfoService;

@Service("STockMoneyFlowInfoService")
public class StockMoneyFlowInfoImpl implements STockMoneyFlowInfoService{
	@Autowired
	private StockMoneyFlowInfoDao stockMoneyFlowInfoDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return stockMoneyFlowInfoDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockMoneyFlowInfoDao.queryList(map);
	}

	@Override
	public int delete(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return stockMoneyFlowInfoDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockMoneyFlowInfoDao.queryList(map);
	}

	@Override
	public int delete(HashMap<String, Object> map) {
		
		return stockMoneyFlowInfoDao.delete(map);
	}*/

}
