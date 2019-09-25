package com.ts.module.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ts.module.system.model.SSessionLog;

public interface SSessionLogService {
	
	public int querySessionLogListCount(String userId);
	
	public List<HashMap<String,Object>> querySessionLogByUserID(HashMap<String,Object> map);
	
	public int queryCountByMd5(String md5);
	
	public int addSessionLog(SSessionLog sSessionLog); 
	
	public int updateSessionLog(SSessionLog sSessionLog);
	
	public int deleteSessionLog(Map<String,Object> map);
}
