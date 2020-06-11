package com.system.controller;

import com.system.model.User;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(user);
        int i = userService.updateByPrimaryKeySelective(user);
        if( i > 1){
            return "<script>alert('修改成功！');history.go(-1)</script>";
        }
        return "<script>alert('修改失败！');history.go(-1)</script>";
    }

   /* //修改管理员密码
    @PostMapping("/userPwdRest")
    public String pwdRest(String oldPwd,String newPwd){
        int i = userService.updateByPrimaryKeySelective(oldPwd,newPwd);
        if( i > 1){
            return "<script>alert('修改成功！');history.go(-2)</script>";
        }
        return "<script>alert('修改失败！');history.go(-1)</script>";
    }
*/
}
