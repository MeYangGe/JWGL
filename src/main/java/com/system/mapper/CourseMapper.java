package com.system.mapper;

import com.system.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    List<Course> selectAll(@Param("key") String key);

    List<Course> selectCourseBySid(@Param("sid") Integer sid);
}