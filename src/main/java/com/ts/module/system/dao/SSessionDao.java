package com.ts.module.system.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ts.module.system.model.SSession;

public interface SSessionDao {
	public int queryListCount();
	
	public SSession querySession(@Param("sessionId")String sessionId);
	
	public List<HashMap<String,Object>> querySessionByUserName(HashMap<String,Object> map);
	
	public int addSession(SSession sSession); 
	
	public int updateSession(SSession sSession);
	
	public int deleteSession(Map map);
}
