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

    //修改管理员密码   当时写方法的时候，没有考虑周到
    int updateManagerPwd(@Param("user") User user);

    //添加一个用户
    int addUser(User user);

    //删除一条数据
    int deleteUser(Integer uid);

    //修改用户信息
    int updateUserByInfo(User user);
}