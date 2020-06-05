package com.system.mapper;


import com.system.model.Course_Stu;
import com.system.model.Course_StuCustom;

public interface SelectedcourseMapper {

    int insert(Course_Stu course_stu);


   int selectByscid(Course_StuCustom course_stuCustom);



}