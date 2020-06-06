package com.system.service.impl;

import com.system.mapper.Course_StuMapper;
import com.system.model.Course;
import com.system.model.Course_Stu;
import com.system.model.Student;
import com.system.service.Course_StuService;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/5 14:47
 */
@Service
public class Course_StuServiceImpl implements Course_StuService {
    @Autowired
    Course_StuMapper selectedcourseMapper;

    @Override
    public int insert(Course_Stu course_stu) {
        return selectedcourseMapper.insert(course_stu);
    }
    
    @Override
    public String selectByscid(Integer cid) {
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        Course_Stu course_stu = new Course_Stu();
        Course course = new Course();
        course.setCid(cid);
        course_stu.setCourse(course);
        Student student = new Student();
        student.setSid(sid);
        course_stu.setStudent(student);
        //进数据库查询是否已经选过此课程
        List<Course_Stu> course_stuCustoms = selectedcourseMapper.selectByscid(course_stu);
        if(course_stuCustoms.size()>0){
            //已经选过  返回错误并提示
            return "你已经选过该课程了";
        }else{
            insert(course_stu);
        }
        return "选课成功";
    }
    @Override
    public String upadte(Integer cid){
        Subject subject = SecurityUtils.getSubject();
        Integer sid = (Integer) subject.getPrincipal();
        Course_Stu course_stu = new Course_Stu();
        Course course = new Course();
        course.setCid(cid);
        course_stu.setCourse(course);
        Student student = new Student();
        student.setSid(sid);
        course_stu.setStudent(student);
        int upadte =selectedcourseMapper.upadte(course_stu);
        if(upadte>0){
            //已经选过  返回错误并提示
            return "退课成功";
        }else{
            return "选课失败";
        }
    }
}