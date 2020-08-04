package com.huawei.chinasoft.springbootshiro.entity;

import lombok.Data;

/**
 * 项目名称: springboot-shiro
 * @ClassName Permission
 * @Description
 * @Author huipanxing huipanxing@chinasofti.com   @Date 2020/8/4 14:20
 */
@Data
public class Permission {

    private Integer id;

    private String permissionName;

    private Integer roleId;
}
