package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.CrawlerCronJobDao;
import com.ts.module.crawler.service.CRawlerCronJobService;

@Service("CRawlerCronJobService")
public class CrawlerCronJobImpl implements CRawlerCronJobService{
	@Autowired
	private CrawlerCronJobDao crawlerCronJobDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return crawlerCronJobDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return crawlerCronJobDao.queryList(map);
	}

	@Override
	public int delete(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
}
