package com.system.mapper;


import com.github.pagehelper.PageInfo;
import com.system.model.Course_Stu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Course_StuMapper {

    int insert(@Param("course_stu") Course_Stu course_stu);

    int upadte(@Param("course_stu") Course_Stu course_stu);

    List<Course_Stu> selectByscid(@Param("course_stu") Course_Stu course_stu);

    List<Course_Stu> selectCourseBySidAndStatus(@Param("course_stu") Course_Stu course_stu);

    int deleteCourse_stuByCid(Integer cid);

    int deleteCourse_stuBySid(Integer sid);
}