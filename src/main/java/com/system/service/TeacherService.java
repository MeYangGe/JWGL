package com.system.service;

import com.system.model.Teacher;
import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 11:48
 */
public interface TeacherService {
    /***
     * 获得所有的教师信息
     * @return 教师信息
     */
    List<Teacher> findAll();
}
