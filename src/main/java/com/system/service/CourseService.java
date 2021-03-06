package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Course;
import com.system.util.ResultVM;
import org.apache.ibatis.annotations.Param;

public interface CourseService {

 ResultVM selectAll(String key, int pageNum, int pageSize);
 ResultVM selectCourseBySid(int pageNum, int pageSize);

 /***
  *  添加一个课程
  * @param course 课程对象
  * @return 受影响行数
  */
 int addCourse(Course course);

 /***
  *  删除一个课程
  * @param cid 课程id
  * @return 受影响行数
  */
 int deleteCourse(Integer cid);

 /***
  *  修改一个课程
  * @param course 课程对象
  * @return 受影响行数
  */
 int updateCourse(Course course);

 /***
  * 根据名字 动态分页查询
  * @param page 当前页
  * @param pageSize 每页条数
  * @param name 老师名
  * @return pageInfo对象
  */
 public PageInfo<Course> findAllByNameWithPage(int page, int pageSize, String name);

 public PageInfo<Course> selectCourseByTidAndCname(int pageNum, int pageSize, String cname);

 /***
  * @return 所有课程条数
  */
 int getTotalNum();
/**
 * @return 所有学生所选课程条数
 * */
 int selectCourseCountBySid(@Param("sid") Integer sid);
}
