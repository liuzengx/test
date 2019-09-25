package com.ts.module.system.model;

import java.io.Serializable;

public class SSession implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sessionId;
	private String hostIp;
	private long timeout;
	private String startTime;
	private String lastTime;
	private String userId;
	private String userName;
	private String loginName;
	private String session;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	
	
	public SSession(String sessionId, String hostIp, String userName)
	{
		super();
		this.sessionId = sessionId;
		this.hostIp = hostIp;
		this.userName = userName;
	}
	public SSession()
	{
		super();
	}
	public String toString() {
		return "SSession [sessionId=" + sessionId + ", hostIp=" + hostIp
				+ ", userName=" + userName +"]";
	}
	
}
