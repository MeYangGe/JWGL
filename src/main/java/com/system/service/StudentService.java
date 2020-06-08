package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    public int deleteByPrimaryKey(Integer sid);

    public int insert(Student record);

    public int insertSelective(Student record);

    public  Student selectByPrimaryKey(Integer sid);

    public int updateByPrimaryKeySelective(Student record);

    public int updateByPrimaryKey(Student record);

    public PageInfo<Student> selectByCid(int pageNum, int pageSize,Integer cid);
}
