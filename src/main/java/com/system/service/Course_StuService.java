package com.system.service;

import com.system.model.Course_Stu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/5 14:47
 */
public interface Course_StuService {
    int insert(Course_Stu course_stu);

    String upadte(Integer cid);

    String selectByscid(Integer cid);
}
