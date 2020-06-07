package com.system.mapper;

import com.system.model.Student;

public interface StudentMapper {
    Student selectByPrimaryKey(Integer sid);
    
}