package com.system.service.impl;

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
}
