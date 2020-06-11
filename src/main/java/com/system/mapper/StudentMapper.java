package com.system.mapper;

import com.system.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student selectByPrimaryKey(Integer sid);



    //分割线
    int addStudent(Student student);

    int deleteStudent(Integer sid);

    int updateStudent(Student student);

    int getTotalNum();

    List<Student> findAllByName(@Param("name") String name);
}