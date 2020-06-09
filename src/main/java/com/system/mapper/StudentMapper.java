package com.system.mapper;

import com.system.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student selectByPrimaryKey(Integer sid);

    List<Student> selectByCid(@Param("cid") Integer cid);

    //分割线
    int addStudent(Student student);

    int deleteStudent(Integer sid);

    int updateStudent(Student student);

    List<Student> findAllByName(@Param("name") String name);
}