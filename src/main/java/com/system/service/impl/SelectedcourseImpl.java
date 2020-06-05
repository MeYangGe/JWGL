package com.system.service.impl;

import com.system.mapper.SelectedcourseMapper;
import com.system.model.Course_Stu;
import com.system.model.Course_StuCustom;
import com.system.service.SelectedCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/5 14:47
 */
@Service
public class SelectedcourseImpl implements SelectedCourseService {
    @Autowired
    SelectedcourseMapper selectedcourseMapper;

    @Override
    public int insert(Course_StuCustom course_stuCustom) {
        return selectedcourseMapper.insert(course_stuCustom);
    }

    @Override
    public List<Course_StuCustom> selectByscid(Course_StuCustom course_stuCustom) {
        return selectedcourseMapper.selectByscid(course_stuCustom);
    }
    @Override
    public int upadte(@Param("course_stuCustom") Course_StuCustom course_stuCustom){
     return selectedcourseMapper.upadte(course_stuCustom);
    }
}
