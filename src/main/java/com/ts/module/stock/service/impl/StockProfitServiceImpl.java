package com.ts.module.stock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.stock.dao.StockProfitDao;
import com.ts.module.stock.model.StockProfit;
import com.ts.module.stock.service.STockProfitService;

@Service("STockProfitService")
public class StockProfitServiceImpl implements STockProfitService{
	@Autowired
	private StockProfitDao stockProfitDao;
	
	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return stockProfitDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockProfitDao.queryList(map);
	}

	@Override
	public int addStockProfit(HashMap<String,Object> map) {
		
		return stockProfitDao.addStockProfit(map);
	}

	@Override
	public int updateStockProfit(HashMap<String,Object> map) {
		
		return stockProfitDao.updateStockProfit(map);
	}

	@Override
	public int deleteStockProfit(HashMap<String, Object> map) {
		
		return stockProfitDao.deleteStockProfit(map);
	}

}
