package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.CourseMapper;
import com.system.mapper.TeacherMapper;
import com.system.mapper.UserMapper;
import com.system.model.Role;
import com.system.model.Teacher;
import com.system.model.User;
import com.system.service.TeacherService;
import com.system.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public int addTeacher(Teacher teacher) {
        int i = teacherMapper.addTeacher(teacher);
        //添加到 user 表
        userMapper.addUser(new User(teacher.getTid(),teacher.getName(), MD5.getMD5("123456",teacher.getTid()),new Role(2)));
        return i;
    }

    @Override
    public int deleteTeacher(Integer tid) {
        //从user表删除
        userMapper.deleteUser(tid);
        return teacherMapper.deleteTeacher(tid);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        //如果修改了名字，则user表一起修改
        User user = new User();
        user.setUid(teacher.getTid());
        user.setUname(teacher.getName());
        userMapper.updateUserByInfo(user);
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public PageInfo<Teacher> findAllByNameWithPage(int page, int pageSize, String name) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(teacherMapper.findAllByName(name));
    }

    @Override
    public int getTotalNum() {
        return teacherMapper.getTotalNum();
    }

    @Override
    public Teacher getTeacher() {
        Subject subject = SecurityUtils.getSubject();
        Integer tid = (Integer) subject.getPrincipal();
        return teacherMapper.getTeacher(tid);
    }
}
