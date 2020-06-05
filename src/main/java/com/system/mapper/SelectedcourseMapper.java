package com.system.mapper;


import com.system.model.Course_Stu;
import com.system.model.Course_StuCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedcourseMapper {

    int insert(@Param("course_stuCustom") Course_StuCustom course_stuCustom);

    int upadte(@Param("course_stuCustom") Course_StuCustom course_stuCustom);

    List<Course_StuCustom> selectByscid(@Param("course_stuCustom") Course_StuCustom course_stuCustom);



}