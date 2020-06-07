package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.util.ResultVM;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

 ResultVM selectAll(String key, int pageNum, int pageSize);
 ResultVM selectCourseBySid(int pageNum, int pageSize);
}
