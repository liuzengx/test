package com.ts.module.crawler.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.crawler.dao.CrawlerUrlTaskDao;
import com.ts.module.crawler.service.CRawlerUrlTaskService;

@Service("CRawlerUrlTaskService")
public class CrawlerUrlTaskImpl implements CRawlerUrlTaskService{
	@Autowired
	private CrawlerUrlTaskDao crawlerUrlTaskDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return crawlerUrlTaskDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return crawlerUrlTaskDao.queryList(map);
	}

	@Override
	public int delete(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
}
