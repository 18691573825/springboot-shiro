package com.huawei.chinasoft.springbootshiro.service;

import com.huawei.chinasoft.springbootshiro.Mapper.UserMapper;
import com.huawei.chinasoft.springbootshiro.entity.Permission;
import com.huawei.chinasoft.springbootshiro.entity.Role;
import com.huawei.chinasoft.springbootshiro.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目名称: springboot-shiro
 * @ClassName UserServiceImpl
 * @Description
 * @Author huipanxing huipanxing@chinasofti.com   @Date 2020/8/4 14:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 14:23
     * @param username
     * @return java.util.List<com.huawei.chinasoft.springbootshiro.entity.Role>
     */
    @Override
    public List<Role> getRoles(String username) {
        return userMapper.getRoles(username);
    }

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 14:23
     * @param username
     * @return java.util.List<com.huawei.chinasoft.springbootshiro.entity.Permission>
     */
    @Override
    public List<Permission> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }

    /**
     * 功能描述:
     * @author huipanxing huipanxing@chinasofti.com
     * @date 2020/8/4 15:11
     * @param username
     * @return com.huawei.chinasoft.springbootshiro.entity.User
     */
    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);

    }
}
