package com.system.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MeYanGe on 2020/6/5.
 */
public class Course_Stu implements Serializable {
    private Integer csi;



    //新增Student 对象字段
    private Student student;

    //扩展课程信息对象
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
    public Integer getCsi() {
        return csi;
    }

    public void setCsi(Integer csi) {
        this.csi = csi;
    }
}
