package com.system.service.impl;

import com.github.pagehelper.PageInfo;
import com.system.mapper.Course_StuMapper;
import com.system.model.Course;
import com.system.mapper.CourseMapper;
import com.system.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.system.util.ResultVM;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    private Course_StuMapper cs;

    @Override
    public ResultVM selectAll(String key, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseMapper.selectAll(key));
        return ResultVM.ok(pageInfo);
    }

    @Override
    public ResultVM selectCourseBySid(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseMapper.selectCourseBySid(sid));
        return ResultVM.ok(pageInfo);
    }



    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteCourse(Integer cid) {
        //在删除课程的同时，将他的学生删除
        cs.deleteCourse_stuByCid(cid);
        return courseMapper.deleteCourse(cid);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public PageInfo<Course> findAllByNameWithPage(int page, int pageSize, String name) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(courseMapper.findAllByName(name));
    }

    @Override
    public PageInfo<Course> selectCourseByTidAndCname(int pageNum, int pageSize,  String cname) {
        PageHelper.startPage(pageNum,pageSize);
        Subject subject = SecurityUtils.getSubject();
        Integer tid = (Integer) subject.getPrincipal();

        return new PageInfo<Course>(courseMapper.selectCourseByTidAndCname(tid, cname));
    }
}
