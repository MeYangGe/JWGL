package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

 PageInfo selectAll(String key, int pageNum, int pageSize);
 PageInfo selectCourseBySid(int pageNum, int pageSize);
}
