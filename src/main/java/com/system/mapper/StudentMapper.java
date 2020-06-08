package com.system.mapper;

import com.system.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student selectByPrimaryKey(Integer sid);

    List<Student>  selectByCid(@Param("cid") Integer cid);
}