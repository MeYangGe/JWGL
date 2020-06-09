package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.Course_StuMapper;
import com.system.model.Student;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PipedReader;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    private Course_StuMapper cs;

    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public PageInfo<Student> selectByCid(int pageNum, int pageSize, Integer cid) {
        return new PageInfo<Student>(studentMapper.selectByCid(cid));
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudent(Integer sid) {
        //在删除学生的同时，将他的课程删除
        cs.deleteCourse_stuBySid(sid);
        return studentMapper.deleteStudent(sid);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public PageInfo<Student> findAllByNameWithPage(int page, int pageSize, String name) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(studentMapper.findAllByName(name));
    }

}
