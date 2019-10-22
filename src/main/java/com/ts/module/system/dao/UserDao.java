package com.ts.module.system.dao;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
	
	public int queryListCount();
	
	public List<HashMap<String,Object>> queryList(HashMap<String,Object> map);
	
	public int addUser(HashMap<String,Object> map);
	
	public int updateUser(HashMap<String,Object> map);
	
	public int deleteUser(HashMap<String,Object> map);
}
