package com.ts.module.stock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ts.module.stock.model.StockProfit;
import com.ts.module.system.model.SSession;

public interface StockProfitDao {
	
	public int queryListCount();
	
	public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
	
	public int addStockProfit(HashMap<String,Object> map);
	
	public int updateStockProfit(HashMap<String,Object> map);
	
	public int deleteStockProfit(HashMap<String,Object> map);
}
