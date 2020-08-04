package com.huawei.chinasoft.springbootshiro.common;

import com.huawei.chinasoft.springbootshiro.entity.Permission;
import com.huawei.chinasoft.springbootshiro.entity.Role;
import com.huawei.chinasoft.springbootshiro.entity.User;
import com.huawei.chinasoft.springbootshiro.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 项目名称: springboot-shiro
 * @ClassName MyRealm
 * @Description
 * @Author huipanxing huipanxing@chinasofti.com   @Date 2020/8/4 14:13
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.getRoles(username).stream()
                .map(Role::getRolename).collect(Collectors.toSet()));
        simpleAuthorizationInfo.setStringPermissions(userService.getPermissions(username).stream()
                .map(Permission::getPermissionName).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.getByUsername(username);
        if (user != null) {
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
