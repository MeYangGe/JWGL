package com.system.controller;


import com.github.pagehelper.PageInfo;
import com.system.model.Student;
import com.system.service.CourseService;
import com.system.service.Course_StuService;
import com.system.service.StudentService;
import com.system.service.UserService;
import com.system.util.ResultVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author  JGW
 * @date  2020-06-05 08点08分
 * @version 1.0
 * 学生 Conreoller
 */
@RestController//代表@ResponseBody和@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

    @Autowired
    Course_StuService course_stuService;

    //根据ID查询学生信息
    @GetMapping("/student/{id}")
    public ResultVM student(@PathVariable("id") Integer id){
        //调用
        return ResultVM.ok(studentService.selectByPrimaryKey(id));
    }

    //学生选课
    @GetMapping("stuSelectedCourse/{cid}")
    public ResultVM stuSelectedCourse(@PathVariable("cid") Integer cid){
        //返回定制实体类结果
        return course_stuService.selectByscid(cid);

    }

    //学生退课
    @GetMapping("outCourse/{cid}")
    public ResultVM outCourse(@PathVariable("cid") Integer cid){
        return course_stuService.upadte(cid);
    }
    //分页以及带条件的查询所有课程
    @GetMapping("/courses")
    public ResultVM getAll(String key, @RequestParam(name = "pageNum",defaultValue = "1") int pageNum, @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        //返回定制实体类结果
        return courseService.selectAll(key,pageNum,pageSize);
    }
    //分页以及带条件的查询学生已选课程ID
    @GetMapping("Selectedcourses")
    public ResultVM getSelectedcourses(@RequestParam(name = "pageNum",defaultValue = "1") int pageNum, @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        //返回定制实体类结果
        return courseService.selectCourseBySid(pageNum,pageSize);
    }
    @GetMapping("Repairedcourses")
    public ResultVM getRepairedcourses(@RequestParam(name = "pageNum",defaultValue = "1") int pageNum, @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        //返回定制实体类结果
        return course_stuService.selectCourseBySidAndStatus(pageNum,pageSize);
    }
    //重置密码
    @GetMapping("Resetpassword")
    public ResultVM resetPassword(String oldpwd,String newpwd){
        return userService.updateByPrimaryKeySelective(oldpwd,newpwd);
    }



    //动态分页获取学生信息
    @PostMapping("/findAllByName")
    public ResultVM findAllByName(
            String name,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<Student> pageInfo = studentService.findAllByNameWithPage(page, pageSize, name);
        return ResultVM.ok(pageInfo);
    }

    //添加一条数据
    @PostMapping("/addStudent")
    public ResultVM addStudent(Student student){
        int i = studentService.addStudent(student);
        if(i > 0){
            return ResultVM.ok("添加成功!");
        }
        return ResultVM.error("添加失败");
    }

    //删除一条数据
    @GetMapping("/deleteStudent/{sid}")
    public ResultVM deleteStudent(@PathVariable("sid") Integer sid){
        int i = studentService.deleteStudent(sid);
        if(i > 0){
            return ResultVM.ok("删除成功!");
        }
        return ResultVM.error("删除失败");
    }

    //修改一条数据
    @PostMapping("/updateStudent")
    public ResultVM updateStudent(Student student){
        int i = studentService.updateStudent(student);
        if(i > 0){
            return ResultVM.ok("修改成功!");
        }
        return ResultVM.error("修改失败");
    }

}
