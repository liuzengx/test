package com.ts.module.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.module.system.dao.SSessionDao;
import com.ts.module.system.model.SSession;
import com.ts.module.system.service.SSessionService;
@Service("SSessionService")
public class SSessionServiceImpl implements SSessionService{
	@Autowired
	private SSessionDao sSessionDao;
	
	@Override
	public SSession querySession(String sessionId) {
		SSession sessionResult = sSessionDao.querySession(sessionId);
		
		return sessionResult;
	}

	@Override
	public List<HashMap<String,Object>> querySessionByUserName(HashMap<String,Object> map) {
		List<HashMap<String,Object>> list = sSessionDao.querySessionByUserName(map);
		
		return list;
	}

	@Override
	public int addSession(SSession sSession) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSession(SSession sSession) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSession(Map map) {
		int delSessionCount = 0;
		delSessionCount = sSessionDao.deleteSession(map);
		
		return delSessionCount;
	}

	@Override
	public int queryListCount() {
		
		return sSessionDao.queryListCount();
	}

}
