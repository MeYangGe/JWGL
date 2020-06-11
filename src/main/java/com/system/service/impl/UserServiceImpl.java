package com.system.service.impl;

import com.system.model.User;
import com.system.mapper.UserMapper;
import com.system.service.UserService;
import com.system.util.MD5;
import com.system.util.ResultVM;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public User selectBySelective(User user) {
        return userMapper.selectBySelective(user);
    }

    @Override
    public User selectByUname(String uname) {
        return userMapper.selectByUname(uname);
    }

    @Override
    public String getPermissions(Integer uid) {
        return userMapper.getPermissions(uid);
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public ResultVM updateByPrimaryKeySelective(String oldpwd, String newpwd) {
        Subject subject = SecurityUtils.getSubject();
        User user = selectByPrimaryKey(Integer.valueOf((Integer) subject.getPrincipal()));
        String md5 = MD5.getMD5(oldpwd,subject.getPrincipal());
        if(md5.equals(user.getPwd())){
            user.setPwd(MD5.getMD5(newpwd,subject.getPrincipal()));
            userMapper.updateByPrimaryKeySelective(user);
            return  ResultVM.ok("修改成功");
        }else{
            return ResultVM.error("旧密码不正确");
        }

    }
    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

}
