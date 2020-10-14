package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.StockAnalysisReportDao;
import com.ts.module.crawler.service.STockAnalysisReportService;

@Service("STockAnalysisReportService")
public class StockAnalysisReportImpl implements STockAnalysisReportService{
	@Autowired
	private StockAnalysisReportDao stockAnalysisReportDao;

	@Override
	public int queryJyrCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryJyrCount(map);
	}

	@Override
	public String queryDateQj(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryDateQj(map);
	}

	@Override
	public int queryZsyCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZsyCount(map);
	}

	@Override
	public int queryFsyCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryFsyCount(map);
	}
	
	@Override
	public int queryFsy_KzyCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryFsy_KzyCount(map);
	}

	@Override
	public int queryWsyCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryWsyCount(map);
	}
	//等于
	@Override
	public int querySpjDyZdjCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.querySpjDyZdjCount(map);
	}

	//大于
	@Override
	public int querySpjDdyZdjCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.querySpjDdyZdjCount(map);
	}

	@Override
	public int queryZgj_Kpj_0_00Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_00Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_05Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_05Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_10Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_10Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_15Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_15Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_20Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_20Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_25Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_25Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_30Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_30Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_35Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_35Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_40Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_40Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_45Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_45Count(map);
	}

	@Override
	public int queryZgj_Kpj_0_50Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryZgj_Kpj_0_50Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_00Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_00Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_05Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_05Count(map);
	}
	
	@Override
	public int queryKpj_Zdj_0_10Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_10Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_15Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_15Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_20Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_20Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_25Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_25Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_30Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_30Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_35Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_35Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_40Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_40Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_45Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_45Count(map);
	}

	@Override
	public int queryKpj_Zdj_0_50Count(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return stockAnalysisReportDao.queryKpj_Zdj_0_50Count(map);
	}
}
