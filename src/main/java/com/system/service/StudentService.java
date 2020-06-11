package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {

    public  Student selectByPrimaryKey(Integer sid);


    /***
     *  添加一条数据
     * @param student   学生对象
     * @return  受影响行数
     */
    int addStudent(Student student);

    /***
     * 删除一条数据
     * @param sid   学生id
     * @return  受影响行数
     */
    int deleteStudent(Integer sid);

    /***
     *  修改一条数据
     * @param student   学生对象
     * @return  受影响行数
     */
    int updateStudent(Student student);

    /***
     *  动态分页查询信息
     * @param page  当前页
     * @param pageSize  每页条数
     * @param name  学生名
     * @return
     */
    PageInfo<Student> findAllByNameWithPage(int page, int pageSize, String name);

    /***
     * @return 所有课程条数
     */
    int getTotalNum();
}
