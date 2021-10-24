package com.example.edusystem.controllers;

import com.example.edusystem.entity.Student;
import com.example.edusystem.mapper.StudentMapper;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("login")
    public String login(int studentId,String studentPassword){
        if(StringUtils.isNullOrEmpty(studentPassword))
        {
            return "关键数据存在空值";
        }
        Student student = studentMapper.loginStudent(studentId);

        if(student==null)
        {
            return "登录失败";
        }
        if(studentPassword.equals(student.getStudentPassword()))
        {
            return "登录成功";
        }
        return "登录密码错误";
    }


    @GetMapping("register")
    public String register(String studentName,String studentPassword,String studentEmail){
        int studentStatus = 1;
        if(StringUtils.isNullOrEmpty(studentName)|| StringUtils.isNullOrEmpty(studentPassword)|| StringUtils.isNullOrEmpty(studentEmail))
        {
            return "关键数据存在空值";
        }
        int resultCount = studentMapper.registerStudent(studentName,studentPassword,studentEmail,studentStatus);
        if(resultCount ==0)
        {
            return "注册失败";
        }
        return "注册成功";
    }

}
