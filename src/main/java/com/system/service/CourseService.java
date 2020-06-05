package com.system.service;

import com.system.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

 List<Course> selectAll(String key, int pageNum, int pageSize);
 List<Course> selectCourseBySid(Integer sid, int pageNum, int pageSize);
}
