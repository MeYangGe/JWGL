package com.system.mapper;

import com.system.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //根据ID查找用户
    User selectByPrimaryKey(Integer uid);

    //根据账号密码查找学生
    User selectBySelective(User user);
    //根据name查找用户
    User selectByUname(String uname);

    //根据用户名查找用户权限
    String getPermissions(Integer sid);

    //修改非管理员密码
    int updateByPrimaryKeySelective(@Param("user") User user);

    //修改密码，并校验旧密码
    int updateUser(@Param("oldPwd") String oldPwd,@Param("user") User user);

}