package com.huawei.chinasoft.springbootshiro.entity;

import lombok.Data;

/**
 * 项目名称: springboot-shiro
 * @ClassName User
 * @Description
 * @Author huipanxing huipanxing@chinasofti.com   @Date 2020/8/4 14:17
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer roleId;

}
