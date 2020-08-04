package com.huawei.chinasoft.springbootshiro.service;

import com.huawei.chinasoft.springbootshiro.entity.Permission;
import com.huawei.chinasoft.springbootshiro.entity.Role;
import com.huawei.chinasoft.springbootshiro.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 14:22
     * @param username
     * @return java.util.List<com.huawei.chinasoft.springbootshiro.entity.Role>
     */
    List<Role> getRoles(String username);

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 14:25
     * @param username
     * @return java.util.List<com.huawei.chinasoft.springbootshiro.entity.Permission>
     */
    List<Permission> getPermissions(String username);

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 15:11
     * @param username
     * @return com.huawei.chinasoft.springbootshiro.entity.User
     */
    User getByUsername(String username);
}
