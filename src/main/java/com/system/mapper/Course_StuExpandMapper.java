package com.system.mapper;

import com.system.model.Course_StuExpand;
import com.system.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Zqb
 * @Description:
 * @Date: Created in 17:37 2020/6/10
 * @Modified By:
 */
public interface Course_StuExpandMapper {
    List<Course_StuExpand> selectByCid(@Param("cid") Integer cid);
}
