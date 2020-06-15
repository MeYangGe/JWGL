package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Course_Stu;
import com.system.util.ResultVM;
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

    int upadteAchievement(int cid,int sid,Double achievement);

    Integer selectCourseCountBySidAndStatus();

    ResultVM upadte(Integer cid);

    ResultVM selectByscid(Integer cid);

    ResultVM selectCourseBySidAndStatus(int pageNum, int pageSize);

    Integer selectedCourseCountBySidAndStatus();
}
