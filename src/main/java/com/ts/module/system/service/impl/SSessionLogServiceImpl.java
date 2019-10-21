package com.ts.module.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.system.dao.SSessionLogDao;
import com.ts.module.system.model.SSessionLog;
import com.ts.module.system.service.SSessionLogService;

@Service("SSessionLogService")
public class SSessionLogServiceImpl implements SSessionLogService{
	@Autowired
	private SSessionLogDao sSessionLogDao;

	@Override
	public int querySessionLogListCount(String userId) {
		
		return sSessionLogDao.querySessionLogListCount(userId);
	}

	@Override
	public List<HashMap<String, Object>> querySessionLogByUserID(HashMap<String, Object> map) {
		List<HashMap<String,Object>> sessionLogList = sSessionLogDao.querySessionLogByUserID(map);
		return sessionLogList;
	}

	@Override
	public int addSessionLog(SSessionLog sSessionLog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSessionLog(SSessionLog sSessionLog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSessionLog(Map<String, Object> map) {
		int count = sSessionLogDao.deleteSessionLog(map);
		
		return count;
	}

	@Override
	public int queryCountByMd5(String md5) {
		
		return sSessionLogDao.queryCountByMd5(md5);
	}

}
