package com.ts.module.system.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.ts.module.system.dao.SSessionDao;
import com.ts.module.system.dao.SSessionLogDao;
import com.ts.module.system.model.SSession;
import com.ts.module.system.model.SSessionLog;
import com.ts.module.system.utils.SerializableUtils;
import com.ts.module.utils.ModUtil;

public class MemorySessionDAO extends EnterpriseCacheSessionDAO {

	@Autowired
	private SSessionDao sSessionDao;
	@Autowired
	private SSessionLogDao sSessionLogDao;
	//删除session数据
	protected void doDelete(Session session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", session.getId().toString());
		sSessionDao.deleteSession(map);
	}
	//更新session数据
	protected void doUpdate(Session session) throws UnknownSessionException {
		// 当是ValidatingSession 无效的情况下，直接退出
		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
			return;
		}
		String sessionid = session.getId().toString();
		String serializSession = SerializableUtils.serializ(session);
		String startTime = ModUtil.dateToString(session.getStartTimestamp());
		String lastAccessTime = ModUtil.dateToString(session.getLastAccessTime());
		String onlineTime=ModUtil.betweenTime(startTime,lastAccessTime);
		String hostIp = ModUtil.ipFormat(session.getHost());
		long timeout = session.getTimeout();
		String md5 ="";
		int countByMd5 =0;
		
		//检索到用户
		 String userStr = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)); 
		//序列化Session
		SSession ssession = new SSession();
		ssession.setSessionId(sessionid);
		ssession.setSession(serializSession);
		ssession.setStartTime(startTime);
		ssession.setLastTime(lastAccessTime);
		ssession.setHostIp(hostIp);
		ssession.setTimeout(timeout);
		
		SSessionLog sSessionLog=new SSessionLog();
		sSessionLog.setSessionId(sessionid);
		sSessionLog.setSession(serializSession);
		sSessionLog.setStartTime(startTime);
		sSessionLog.setLastTime(lastAccessTime);
		sSessionLog.setHostIp(hostIp);
		sSessionLog.setTimeout(timeout);
		sSessionLog.setOnlineTime(onlineTime);
		
		
		if (!userStr.equals("null")) {
			String str = String.valueOf( session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			Map<String, Object> map = ModUtil.strToMap(str);
			String userId = String.valueOf(map.get("userId"));
			String account = ModUtil.stringReplace(map.get("account").toString());
			String userName = ModUtil.stringReplace(map.get("userName").toString());
			md5 = ModUtil.Md5(sessionid+hostIp+userId+startTime);
			
			ssession.setUserId(userId);
			ssession.setLoginName(account);
			ssession.setUserName(userName);
			
			sSessionLog.setUserId(userId);
			sSessionLog.setLoginName(account);
			sSessionLog.setUserName(userName);
			sSessionLog.setMd5(md5);
			//查询session是否存在于session日志表中
			countByMd5 = this.sSessionLogDao.queryCountByMd5(md5);
		}
		//更新数据库Session表
		this.sSessionDao.updateSession(ssession);
		//插入或更新数据库SessionLog表
		if(countByMd5 == 0 && !md5.equals("")){
			this.sSessionLogDao.addSessionLog(sSessionLog);
		}else if(countByMd5 > 0 && !md5.equals("")){
			this.sSessionLogDao.updateSessionLog(sSessionLog);
		}
		
	}
	//创建session数据
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);

		SSession ssession = new SSession();
		ssession.setSessionId(session.getId().toString());
		ssession.setSession(SerializableUtils.serializ(session));
		// 插入session 到数据库
		this.sSessionDao.addSession(ssession);

		return sessionId;
	}
	//读取session数据
	@Override
	protected Session doReadSession(Serializable sessionId) {
		// 获取session的字符串
		SSession dbSession = this.sSessionDao.querySession(sessionId.toString());
		if (dbSession == null) {
			return null;
		}
		// 加载session数据
		String sessionStr = dbSession.getSession();
		return SerializableUtils.deserializ(sessionStr);

	}
	
}
