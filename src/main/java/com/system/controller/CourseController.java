package com.system.controller;


import com.system.service.CourseService;
import com.system.util.ResultVM;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
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
    @Autowired
    CourseService courseService;

    //分页以及带条件的查询所有课程
    @GetMapping("/courses")
    public ResultVM getAll(String key, @RequestParam(name = "pageNum",defaultValue = "1") int pageNum, @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseService.selectAll(key,pageNum,pageSize));
        //返回定制实体类结果
        return ResultVM.ok(pageInfo);
    }
    //分页以及带条件的查询学生已选课程ID
    @GetMapping("Selectedcourses")
    public ResultVM getSelectedcourses(@RequestParam(name = "pageNum",defaultValue = "1") int pageNum, @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseService.selectCourseBySid(sid,pageNum,pageSize));
        //返回定制实体类结果
        return ResultVM.ok(pageInfo);
    }

}
