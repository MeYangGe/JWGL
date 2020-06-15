package com.system.service;

import com.github.pagehelper.PageInfo;
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

    /***
     * 添加一条数据
     * @param teacher   老师对象
     * @return  受影响行数
     */
    int addTeacher(Teacher teacher);

    /***
     * 删除一条数据
     * @param tid   老师id
     * @return  受影响行数
     */
    int deleteTeacher(Integer tid);

    /***
     * 修改一条数据
     * @param teacher   老师对象
     * @return  受影响行数
     */
    int updateTeacher(Teacher teacher);

    /***
     * 动态分页查询数据
     * @param page  当前页
     * @param pageSize  每页多少条
     * @param name  老师名字
     * @return  pageInfo对象
     */
    PageInfo<Teacher> findAllByNameWithPage(int page, int pageSize, String name);

    /***
     * @return 所有课程条数
     */
    int getTotalNum();

    /***
     * @return 获得当前教师
     */
    Teacher getTeacher();
}
