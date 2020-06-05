package com.system.mapper;

import com.system.model.User;

public interface UserMapper {
/*根据ID查找用户*/
    User selectByPrimaryKey(Integer uid);

/*根据账号密码查找学生*/
    User selectBySelective(User user);
/*根据name查找用户*/
    User selectByUname(String uname);

/* 根据用户名查找用户权限*/
    String getPermissions(String uname);
}