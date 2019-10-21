package com.ts.module.system.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {

	public int queryListCount();

	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map);

	public int addUser(HashMap<String, Object> map);

	public int updateUser(HashMap<String, Object> map);

	public int deleteUser(HashMap<String, Object> map);
}
