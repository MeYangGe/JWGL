package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.model.*;
import com.system.service.*;
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
    @Autowired
    private Course_StuService course_StuService;
    @Autowired
    private Course_StuExpandService course_StuExpandService;


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
        return ResultVM.ok(allByTACWithPage);
    }


    //给学生课程打分
    @PostMapping("/upadteAchievement")
    public ResultVM upadteAchievement(Course_Stu course_stu){
        int i = course_StuService.upadteAchievement(course_stu);
        if (i > 0) {
            return ResultVM.ok("打分成功");
        }
        return ResultVM.ok("打分失败");
    }


    //添加一条数据
    @PostMapping("/addTeacher")
    public String addTeacher(Teacher teacher){
        int i = teacherService.addTeacher(teacher);
        if(i > 0){
            return "<script>alert('添加成功！');history.go(-2)</script>";
        }
        return "<script>alert('添加失败！');history.go(-1)</script>";
    }
    //删除一条数据
    @GetMapping("/deleteTeacher/{sid}")
    public ResultVM deleteTeacher(@PathVariable("sid") Integer sid){
        int i = teacherService.deleteTeacher(sid);
        if(i > 0){
            return ResultVM.ok("删除成功！");
        }
        return ResultVM.error("删除失败！");
    }
    //修改一条数据
    @PostMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        int i = teacherService.updateTeacher(teacher);
        if(i > 0){
            return "<script>alert('修改成功！');history.go(-2)</script>";
        }
        return "<script>alert('修改失败！');history.go(-2)</script>";
    }
    //动态分页查询老师
    @PostMapping("/findAllByName")
    public ResultVM findAllByName(String name,
                                  @RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "5")Integer pageSize){
        PageInfo<Teacher> pageInfo = teacherService.findAllByNameWithPage(page, pageSize, name);
        return ResultVM.ok(pageInfo);
    }

    //课程下学生带分页
    @GetMapping("/findAllByCid")
    public ResultVM findAllByName(int cid,
                                  @RequestParam(defaultValue = "1")Integer page,
                                  @RequestParam(defaultValue = "3")Integer pageSize){
        PageInfo<Course_StuExpand> pageInfo =course_StuExpandService.selectByCid(page, pageSize, cid);
        return ResultVM.ok(pageInfo);
    }

}
