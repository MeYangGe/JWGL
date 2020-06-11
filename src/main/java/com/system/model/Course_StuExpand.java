package com.system.model;

import java.util.List;

/**
 * @Author: Zqb
 * @Description:
 * @Date: Created in 17:30 2020/6/10
 * @Modified By:
 */
public class Course_StuExpand extends Course_Stu{

    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
