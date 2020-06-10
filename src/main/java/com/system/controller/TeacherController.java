package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.model.Course_Stu;
import com.system.model.Student;
import com.system.model.Teacher;
import com.system.service.CourseService;
import com.system.service.Course_StuService;
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

    private Course_StuService course_stuService;

    //获得所有的教师
    @GetMapping("/findAll")
    public ResultVM findAll(){
        List<Teacher> all = teacherService.findAll();
        return ResultVM.ok(all);
    }

    //动态分页查询课程
    @GetMapping("/getCourseByTAC")
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

    //给学生课程打分
    @PostMapping("/upadteAchievement")
    public ResultVM upadteAchievement(Course_Stu course_stu){
        int i = course_stuService.upadteAchievement(course_stu);
        if (i > 0) {
            return ResultVM.ok("打分成功");
        }
        return ResultVM.ok("打分失败");
    }


    //添加一条数据
    @PostMapping("/addTeacher")
    public ResultVM addTeacher(Teacher teacher){
        int i = teacherService.addTeacher(teacher);
        if(i > 0){
            return ResultVM.ok("添加成功");
        }
        return ResultVM.error("添加失败");
    }
    //删除一条数据
    @GetMapping("/deleteTeacher/{sid}")
    public ResultVM deleteTeacher(@PathVariable("sid") Integer sid){
        int i = teacherService.deleteTeacher(sid);
        if(i > 0){
            return ResultVM.ok("删除成功");
        }
        return ResultVM.error("删除失败");
    }
    //修改一条数据
    @PostMapping("/updateTeacher")
    public ResultVM updateTeacher(Teacher teacher){
        int i = teacherService.updateTeacher(teacher);
        if(i > 0){
            return ResultVM.ok("修改成功");
        }
        return ResultVM.error("修改失败");
    }
    //动态分页查询老师
    @PostMapping("/findAllByName")
    public ResultVM findAllByName(String name,
                                  @RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "3")Integer pageSize){
        PageInfo<Teacher> pageInfo = teacherService.findAllByNameWithPage(page, pageSize, name);
        return ResultVM.ok(pageInfo);
    }


}
