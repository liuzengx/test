package com.ts.module.stock.service;

import java.util.HashMap;
import java.util.List;

import com.ts.module.stock.model.StockProfit;

public interface STockProfitService {
	
	public int queryListCount();
	
	public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
	
	public int addStockProfit(HashMap<String,Object> map);
	
	public int updateStockProfit(HashMap<String,Object> map);
	
	public int deleteStockProfit(HashMap<String,Object> map);
}
