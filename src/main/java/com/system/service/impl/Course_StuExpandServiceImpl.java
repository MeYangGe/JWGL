package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.mapper.Course_StuExpandMapper;
import com.system.mapper.Course_StuMapper;
import com.system.model.Course_StuExpand;
import com.system.service.Course_StuExpandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zqb
 * @Description:
 * @Date: Created in 18:12 2020/6/10
 * @Modified By:
 */
@Service
public class Course_StuExpandServiceImpl implements Course_StuExpandService {
    @Autowired
    private Course_StuExpandMapper course_StuExpandMapper;

    @Override
    public PageInfo<Course_StuExpand> selectByCid(int pageNum, int pageSize, Integer cid) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<Course_StuExpand>(course_StuExpandMapper.selectByCid(cid));
    }
}
