package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.Course_StuMapper;
import com.system.mapper.UserMapper;
import com.system.model.Role;
import com.system.model.Student;
import com.system.mapper.StudentMapper;
import com.system.model.User;
import com.system.service.StudentService;
import com.system.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PipedReader;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Course_StuMapper cs;

    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }


    @Override
    public int addStudent(Student student) {
        int i = studentMapper.addStudent(student);
        //在添加学生的同时，加到user表
        userMapper.addUser(new User(student.getSid(),student.getName(), MD5.getMD5("123456",student.getSid()),new Role(3)));
        return i;
    }

    @Override
    public int deleteStudent(Integer sid) {
        //在删除学生的同时，将他的课程删除
        cs.deleteCourse_stuBySid(sid);
        //删除学生的时候，将它从user表删除
        userMapper.deleteUser(sid);
        return studentMapper.deleteStudent(sid);
    }

    @Override
    public int updateStudent(Student student) {
        //user表也进行修改
        User user = new User();
        user.setUid(student.getSid());
        user.setUname(student.getName());
        userMapper.updateUserByInfo(user);
        return studentMapper.updateStudent(student);
    }

    @Override
    public PageInfo<Student> findAllByNameWithPage(int page, int pageSize, String name) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(studentMapper.findAllByName(name));
    }

    @Override
    public int getTotalNum() {
        return studentMapper.getTotalNum();
    }

}
