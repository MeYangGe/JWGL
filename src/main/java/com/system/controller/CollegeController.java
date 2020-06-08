package com.system.controller;

import com.system.service.CollegeService;
import com.system.util.ResultVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author JC
 * @date 2020/6/8 11:44
 */
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

//获得所有的学院信息
    @GetMapping("/findAll")
    public ResultVM findAll(){
        List data = collegeService.findAll();
        return ResultVM.ok(data);
    }
}
