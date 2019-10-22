package com.ts.module.system.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.module.system.dao.UserDao;
import com.ts.module.system.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public int queryListCount() {
		// TODO Auto-generated method stub
		return userDao.queryListCount();
	}

	@Override
	public List<HashMap<String, Object>> queryList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.queryList(map);
	}

	@Override
	public int addUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.addUser(map);
	}

	@Override
	public int updateUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.updateUser(map);
	}

	@Override
	public int deleteUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(map);
	}
	

}
