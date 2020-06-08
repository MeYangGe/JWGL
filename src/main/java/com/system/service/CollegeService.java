package com.system.service;

import com.system.model.College;
import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 11:49
 */
public interface CollegeService {
    /***
     * 获得所有的学院信息
     * @return 学院信息
     */
    List<College> findAll();
}
