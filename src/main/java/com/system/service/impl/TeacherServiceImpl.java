package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.CourseMapper;
import com.system.mapper.TeacherMapper;
import com.system.model.Teacher;
import com.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 11:49
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(Integer tid) {
        return teacherMapper.deleteTeacher(tid);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public PageInfo<Teacher> findAllByNameWithPage(int page, int pageSize, String name) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(teacherMapper.findAllByName(name));
    }
}
