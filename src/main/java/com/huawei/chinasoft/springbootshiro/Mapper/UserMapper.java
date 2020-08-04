package com.huawei.chinasoft.springbootshiro.Mapper;

import com.huawei.chinasoft.springbootshiro.entity.Permission;
import com.huawei.chinasoft.springbootshiro.entity.Role;
import com.huawei.chinasoft.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_role tr left join t_user tu on tr.id=tu.role_id where tu.username=#{username}")
    List<Role> getRoles(String username);

    @Select("select * from t_permission tp left join t_role tr on tr.id=tp.role_id left join t_user tu on tr.id=tu.role_id where tu.username=#{username}")
    List<Permission> getPermissions(String username);

    @Select("select * from t_user where username=#{username}")
    User getByUsername(String username);
}
