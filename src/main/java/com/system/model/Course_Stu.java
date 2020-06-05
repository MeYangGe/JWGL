package com.system.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MeYanGe on 2020/6/5.
 */
public class Course_Stu extends Course_StuCustom implements Serializable {
    //新增Student 对象字段
    private Student student;

    //扩展课程信息对象
    private List<Course> courses;

    //得分
    private Double score;

    //课程状态
    private Integer state ;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
