package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.model.Student;
import com.system.model.Teacher;
import com.system.service.CourseService;
import com.system.service.StudentService;
import com.system.service.TeacherService;
import com.system.util.ResultVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 15:49
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private  StudentService studentService;

    //获得所有的教师
    @GetMapping("/findAll")
    public ResultVM findAll(){
        List<Teacher> all = teacherService.findAll();
        return ResultVM.ok(all);
    }


    //动态分页查询课程
    @PostMapping("/getCourseByTAC")
    public ResultVM getCourseByTAC(
            String cname,
            @RequestParam(value = "page",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Course> allByTACWithPage = courseService.selectCourseByTidAndCname(pageNum, pageSize, cname);
        ResultVM resultVM = new ResultVM();
        resultVM.setCode(200);
        resultVM.setMsg("查询成功!");
        resultVM.setResult(allByTACWithPage);
        return resultVM;
    }

    //课程下学生带分页
    @PostMapping("/getByCid")
    public ResultVM getByCid(
            int cid,
            @RequestParam(value = "page",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Student> allStu = studentService.selectByCid(pageNum, pageSize, cid);
        ResultVM resultVM = new ResultVM();
        resultVM.setCode(200);
        resultVM.setMsg("查询成功!");
        resultVM.setResult(allStu);
        return resultVM;
    }

}
