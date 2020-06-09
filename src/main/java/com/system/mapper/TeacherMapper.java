package com.system.mapper;

import com.system.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> findAll();

    int addTeacher(Teacher teacher);

    int deleteTeacher(Integer tid);

    int updateTeacher(Teacher teacher);

    List<Teacher> findAllByName(@Param("name") String name);
}