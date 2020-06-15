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
    public int updateManagerPwd(String oldpwd, String newpwd) {
        Subject subject = SecurityUtils.getSubject();
        User user = selectByPrimaryKey(Integer.valueOf((Integer) subject.getPrincipal()));
        String md5 = MD5.getMD5(oldpwd,subject.getPrincipal());
        if(md5.equals(user.getPwd())){
            user.setPwd(MD5.getMD5(newpwd,subject.getPrincipal()));
            return userMapper.updateManagerPwd(user);
        }
        return 0;
    }


    @Override
    public int updateByPrimaryKeySelective(User user) {
        //通过名字查到 id
        User user1 = userMapper.selectByUname(user.getUname());
        //转成MD5格式的密码
        user.setPwd(MD5.getMD5(user.getPwd(),user1.getUid()));
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
