package com.system.service;

import com.github.pagehelper.PageInfo;
import com.system.model.Course_StuExpand;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: Zqb
 * @Description:
 * @Date: Created in 18:09 2020/6/10
 * @Modified By:
 */

public interface Course_StuExpandService {
    PageInfo<Course_StuExpand> selectByCid(int pageNum, int pageSize, Integer cid);
}
