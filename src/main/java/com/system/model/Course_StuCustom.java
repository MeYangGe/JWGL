package com.system.model;

import java.io.Serializable;

public class Course_StuCustom implements Serializable {

    private Integer courseid;

    private Integer studentid;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

}