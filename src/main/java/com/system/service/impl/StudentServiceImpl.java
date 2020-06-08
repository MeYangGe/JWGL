package com.system.service.impl;

import com.github.pagehelper.PageInfo;
import com.system.model.Student;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;


    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    public int insertSelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }

    @Override
    public PageInfo<Student> selectByCid(int pageNum, int pageSize, Integer cid) {
        return new PageInfo<Student>(studentMapper.selectByCid(cid));
    }


}
