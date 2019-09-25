package com.ts.shiro;

import com.ts.module.system.model.Permission;
import com.ts.module.system.model.User;
import com.ts.module.system.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

public class MyShiroReaml extends AuthorizingRealm {
	/**
     * 授权
     */
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	System.out.println("************* 2.用户授权 doGetAuthorizationInfo() *************");
        /**
         * 流程 	1.根据用户user->2.获取角色id->3.根据角色id获取权限permission
         */
        //方法一：获得user对象
        User user=(User)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取permission
        if(user!=null) {
            List<Permission> permissionsByUser = shiroService.getPermissionsByUser(user);
            if (permissionsByUser.size()!=0) {
                for (Permission p: permissionsByUser) {

                    info.addStringPermission(p.getUrl());
                }
                return info;
            }
        }

        return null;
    }

	/**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
	@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("************* 1.用户登录认证 doGetAuthenticationInfo() *************");
        //验证账号密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("1:"+token.getUsername());
        User user = shiroService.getUserByUserName(token.getUsername());
        System.out.println("2");
        if(user==null){
            throw new UnknownAccountException("该用户不存在！");
        }else{
        	//进行密码的验证处理
        	String password=new String((char[])token.getCredentials());
        	//将数据库密码与输入的密码进行比较，从而验证密码的有效性
        	if(user.getPassword().equals(password)){
        		//最后的比对需要交给安全管理器
                //三个参数进行初步的简单认证信息对象的包装
                AuthenticationInfo info = new SimpleAuthenticationInfo(
	                		user, 
	                		user.getPassword(), 
	                		this.getClass().getSimpleName()
                		);

                return info;
        	}else {
        		throw new IncorrectCredentialsException("密码错误！");
        	}
        }
        
    }
    private ShiroService shiroService;
	
    public ShiroService getShiroService() {
        return shiroService;
    }
    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }
}
