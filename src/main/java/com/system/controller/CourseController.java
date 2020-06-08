package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.service.CourseService;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JC
 * @date 2020/6/8 11:45
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //动态分页查询课程
    @PostMapping("/findAllByName")
    public ResultVM findAllByName(
            String name,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Course> allByNameWithPage = courseService.findAllByNameWithPage(page,pageSize, name);
        ResultVM resultVM = new ResultVM();
        resultVM.setCode(200);
        resultVM.setMsg("查询成功!");
        resultVM.setResult(allByNameWithPage);
        return resultVM;
    }

    //添加一个课程
    @PostMapping("/saveCourse")
    public ResultVM saveCourse(Course course){
        int i = courseService.addCourse(course);
        ResultVM resultVM = new ResultVM();
        if(i>0){
            resultVM.setCode(200);
            resultVM.setMsg("添加成功！");
            return resultVM;
        }
        resultVM.setCode(233);
        return resultVM;
    }

    //修改一个课程
    @PostMapping("/updateCourse")
    public ResultVM updateCourse(Course course){
        int i = courseService.updateCourse(course);
        ResultVM resultVM = new ResultVM();
        if(i>0){
            resultVM.setCode(200);
            resultVM.setMsg("修改成功！");
            return resultVM;
        }
        resultVM.setCode(233);
        return resultVM;
    }

    //删除一个课程
    @PostMapping("/deleteCourse")
    public ResultVM deleteCourse(Integer cid){
        int i = courseService.deleteCourse(cid);
        ResultVM resultVM = new ResultVM();
        if(i>0){
            resultVM.setCode(200);
            resultVM.setMsg("删除成功！");
            return resultVM;
        }
        resultVM.setCode(233);
        return resultVM;
    }
}
