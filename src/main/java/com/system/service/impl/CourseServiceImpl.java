package com.system.service.impl;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.mapper.CourseMapper;
import com.system.service.CourseService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public PageInfo selectAll(String key, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseMapper.selectAll(key));
        return pageInfo;
    }

    @Override
    public PageInfo selectCourseBySid(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        //封装PageInfo分页工具类
        PageInfo pageInfo = new PageInfo(courseMapper.selectCourseBySid(sid));
        return pageInfo;
    }
}
