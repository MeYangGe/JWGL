package com.system.controller;


import com.system.model.Course_StuCustom;
import com.system.model.User;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import com.system.service.UserService;
import com.system.util.ResultVM;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author  JGW
 * @date  2020-06-05 08点08分
 * @version 1.0
 * 学生Conreoller
 */
@RestController//代表@ResponseBody和@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    @Autowired
    SelectedCourseService selectedCourseService;

    //根据ID查询学生信息
    @GetMapping("/student/{id}")
    public ResultVM student(@PathVariable("id") Integer id){
        //调用
        return ResultVM.ok(studentService.selectByPrimaryKey(id));
    }
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
    //学生选课
    @GetMapping("stuSelectedCourse/{cid}")
    public ResultVM stuSelectedCourse(@PathVariable("cid") Integer cid){
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        Course_StuCustom course_stuCustom = new Course_StuCustom();
        course_stuCustom.setCourseid(cid);
        course_stuCustom.setStudentid(sid);
        //进数据库查询是否已经选过此课程
        List<Course_StuCustom> course_stuCustoms = selectedCourseService.selectByscid(course_stuCustom);
        if(course_stuCustoms.size()>0){
            //已经选过  返回错误并提示
            return ResultVM.error("你已经选过该课程了");
        }else{
            int insert = selectedCourseService.insert(course_stuCustom);
        }
        //返回定制实体类结果
        return ResultVM.ok("选课成功");

    }

    //学生退课
    @GetMapping("outCourse/{cid}")
    public ResultVM outCourse(@PathVariable("cid") Integer cid){
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        Course_StuCustom course_stuCustom = new Course_StuCustom();
        course_stuCustom.setCourseid(cid);
        course_stuCustom.setStudentid(sid);

        int upadte = selectedCourseService.upadte(course_stuCustom);
        if(upadte>0){
            //已经选过  返回错误并提示
            return ResultVM.ok("退课成功");
        }else{
            return ResultVM.error("选课失败");
        }
    }
}
