package com.system.controller;

import com.system.model.User;
import com.system.util.ResultVM;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/7 19:57
 */
@RestController
public class LoginController {
    //登陆操作
    @GetMapping("/login")
    public ResultVM login(User user){
        Subject currentUser = SecurityUtils.getSubject();
        //判断账号或密码是否为空
        if(null==user.getPwd()||null==user.getUid()){
            return ResultVM.error("账号或密码为空");
        }

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(user.getUid()), user.getPwd());
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            }
            catch (AuthenticationException ae) {
                return ResultVM.error("账号或密码错误");
            }
        }
        if (currentUser.hasRole("admin")) {
            return ResultVM.ok("admin");
        } else if (currentUser.hasRole("teacher")) {
            return ResultVM.ok("teacher");
        } else if (currentUser.hasRole("student")) {
            return ResultVM.ok("student");
        }
        return ResultVM.error("密码错误");
    }
}
