package com.system.controller;

import com.system.model.User;
import com.system.service.UserService;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  @author JC
 *  @date 2020/6/11 18:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    //修改非管理员密码
    @PostMapping("/userPwdRest")
    public String userPwdRest(User user){
        int i = userService.updateByPrimaryKeySelective(user);
        if( i > 0){
            return "<script>alert('修改成功！');history.go(-1)</script>";
        }
        return "<script>alert('修改失败！');history.go(-1)</script>";
    }

    //重置密码
    @GetMapping("/resetPwd")
    public String resetPassword(@Param("pldpwd") String oldpwd, @Param("newpwd") String newpwd){
        int i = userService.updateManagerPwd(oldpwd,newpwd);
        if( i > 0){
            return "<script>alert('修改成功！');history.go(-1)</script>";
        }
        return "<script>alert('修改失败！');history.go(-1)</script>";
    }

    //获得当前用户的信息
    @GetMapping("/getUser")
    public User getUser(){
        Integer uid = (Integer) SecurityUtils.getSubject().getPrincipal();
        return userService.selectByPrimaryKey(uid);
    }
}
