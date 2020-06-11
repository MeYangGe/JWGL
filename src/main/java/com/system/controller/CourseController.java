package com.system.controller;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.service.CourseService;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String saveCourse(Course course){
        int i = courseService.addCourse(course);
        ResultVM resultVM = new ResultVM();
        if(i>0){
            return "<script>alert('添加成功！');history.go(-2)</script>";
        }
        resultVM.setCode(233);
        return "<script>alert('添加失败！');history.go(-1)</script>";
    }

    //修改一个课程
    @PostMapping("/updateCourse")
    public String updateCourse(Course course){
        int i = courseService.updateCourse(course);
        ResultVM resultVM = new ResultVM();
        if(i>0){
            return "<script>alert('修改成功！');history.go(-2)</script>";
        }
        return "<script>alert('修改失败！');history.go(-2)</script>";
    }

    //删除一个课程
    @GetMapping("/deleteCourse/{cid}")
    public ResultVM deleteCourse(@PathVariable("cid") Integer cid){
        int i = courseService.deleteCourse(cid);
        if(i>0){
            return ResultVM.ok("删除成功！");
        }
        return ResultVM.error("删除失败！");
    }

    //获得所有的条数
    @GetMapping("/getTotalNum")
    public Integer getTotalNum(){
        int totalNum = courseService.getTotalNum();
        return totalNum;
    }

}
