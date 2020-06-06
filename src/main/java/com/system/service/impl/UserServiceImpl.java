package com.system.service.impl;

import com.system.model.User;
import com.system.mapper.UserMapper;
import com.system.service.UserService;
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
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
