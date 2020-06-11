package com.system.model;

import java.io.Serializable;

/**
 * Created by MeYanGe on 2020/6/5.
 */
public class Course_Stu implements Serializable {
    //主键
    private Integer csi;

    //得分
    private Double achievement;

    //Student 对象字段
    private Student student;

    //课程信息对象
    private Course course;


    //课程状态
    private Integer state ;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getAchievement() {
        return achievement;
    }

    public void setAchievement(Double achievement) {
        this.achievement = achievement;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getCsi() {
        return csi;
    }

    public void setCsi(Integer csi) {
        this.csi = csi;
    }
}
