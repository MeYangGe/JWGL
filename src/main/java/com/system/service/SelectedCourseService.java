package com.system.service;

import com.system.model.Course_Stu;
import com.system.model.Course_StuCustom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/5 14:47
 */
@Service
public interface SelectedCourseService {
    int insert(Course_StuCustom course_stuCustom);

    int upadte(@Param("course_stuCustom") Course_StuCustom course_stuCustom);

    List<Course_StuCustom> selectByscid(Course_StuCustom course_stuCustom);
}
