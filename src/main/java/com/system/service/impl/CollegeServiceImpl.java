package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.model.College;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 11:50
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<College> findAll() {
        return collegeMapper.findAll();
    }
}
