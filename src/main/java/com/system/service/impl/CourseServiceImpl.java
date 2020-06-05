package com.system.service.impl;

import com.system.model.Course;
import com.system.mapper.CourseMapper;
import com.system.service.CourseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> selectAll(String key,int pageNum,int pageSize) {
        System.out.println("111111"+courseMapper.selectAll(key).toString());
        PageHelper.startPage(pageNum,pageSize);

        return courseMapper.selectAll(key);
    }

    @Override
    public List<Course> selectCourseBySid(Integer sid,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return courseMapper.selectCourseBySid(sid);
    }
}
