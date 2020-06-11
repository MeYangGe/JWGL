package com.system.service;

import com.system.model.User;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface UserService {
    public User selectByPrimaryKey(Integer uid);

    public int updateByPrimaryKey(User record);

    public User selectBySelective(User user);

    public User selectByUname(String uname);

    public String getPermissions(Integer uid);

    /***
     *  修改密码，并校验旧密码
     * @param oldpwd 旧密码
     * @param newpwd 新密码
     * @return 受影响行数
     */
     ResultVM updateByPrimaryKeySelective(String oldpwd, String newpwd);


    /***
     *  修改非管理员密码
     * @param user user对象
     * @return  受影响行数
     */
    int updateByPrimaryKeySelective(@Param("user") User user);
}