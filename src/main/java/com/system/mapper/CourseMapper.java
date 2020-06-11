package com.system.mapper;

import com.system.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    List<Course> selectAll(@Param("key") String key);

    List<Course> selectCourseBySid(@Param("sid") Integer sid);

    //    分割线
    int addCourse(Course course);

    int deleteCourse(Integer cid);

    int updateCourse(Course course);

    int getTotalNum();

    List<Course> findAllByName(@Param("name") String name);

    List<Course> selectCourseByTidAndCname(@Param("tid") Integer tid,@Param("cname") String cname);
}