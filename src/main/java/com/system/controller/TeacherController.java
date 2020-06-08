package com.system.controller;

import com.system.model.Teacher;
import com.system.service.TeacherService;
import com.system.util.ResultVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JC
 * @date 2020/6/8 15:49
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //获得所有的教师
    @GetMapping("/findAll")
    public ResultVM findAll(){
        List<Teacher> all = teacherService.findAll();
        return ResultVM.ok(all);
    }


}
