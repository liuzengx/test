package com.ts.module.system.service;

import com.ts.module.system.model.Permission;
import com.ts.module.system.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
public interface ShiroService {

    /**
     * 根据账号获取账号密码
     * @param username
     * @return UserPojo
     */
     User getUserByUserName(String username);

    /**
     * 根据账号获取该账号的权限
     *
     * @param user
     * @return List
     */
    List<Permission> getPermissionsByUser(User user);
}
