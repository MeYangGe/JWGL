package com.system.mapper;


import com.system.model.Course_Stu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Course_StuMapper {

    int insert(@Param("course_stu") Course_Stu course_stu);

    int upadte(@Param("course_stu") Course_Stu course_stu);

    List<Course_Stu> selectByscid(@Param("course_stu") Course_Stu course_stu);



}