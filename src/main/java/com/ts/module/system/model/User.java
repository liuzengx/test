package com.ts.module.system.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/9.
 */
@Component
public class User implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private int userId;
    private String account;
    private String password;
    private String userName;
    private String orgCode;
    private String postCode;
    private int isStop;

    public User(int userId, String account, String password, String userName, String orgCode, String postCode, int isStop) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.orgCode = orgCode;
        this.postCode = postCode;
        this.isStop = isStop;
    }

    public User() {
        super();
    }

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getIsStop() {
		return isStop;
	}

	public void setIsStop(int isStop) {
		this.isStop = isStop;
	}
	@Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", postCode='" + postCode + '\'' +
                ", isStop='" + isStop + '\'' +
                '}';
    }
}
