package com.system.controller;


import com.system.model.User;
import com.system.service.CourseService;
import com.system.util.ResultVM;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  JGW
 * @date 2020-06-05 07:31
 * @version 1.0
 * 课程Controller
 */
@RestController
public class CourseController {
    //登陆操作
    @GetMapping("/login")
    public ResultVM login(User user){
        System.out.println(user.toString());
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
                //unexpected condition?  error?
                return ResultVM.error(ae.getMessage());
            }
        }
        return ResultVM.ok("身份验证成功");
    }
}
