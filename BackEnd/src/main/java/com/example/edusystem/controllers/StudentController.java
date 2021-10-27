package com.example.edusystem.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.edusystem.entity.Student;
import com.example.edusystem.mapper.StudentMapper;
import com.example.edusystem.tools.JwtConfig;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RequestMapping("student")
@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
    @Resource
    private JwtConfig jwtConfig;



    @PostMapping("login")
    public Map<String,Object> login(int studentId,String studentPassword){
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isNullOrEmpty(studentPassword))
        {
            map.put("msg","关键数据存在空值");
            return map;
        }
        Student student = studentMapper.loginStudent(studentId);

        if(student==null)
        {
            map.put("msg","登录失败");
            return map;
        }
        if(studentPassword.equals(student.getStudentPassword()))
        {
            try
            {Map<String,String> payload = new HashMap<>();
            payload.put("studentId", String.valueOf(studentId));
            payload.put("studentPassword",studentPassword);
            String token = JwtConfig.getToken(payload);
            map.put("msg","登录成功");
            map.put("token",token);}
            catch (Exception e){
                map.put("msg",e.getMessage());
            }

            return map;
        }
        else{
            map.put("msg","登录密码错误");
            return map;
        }
    }


    @PostMapping("testlogin")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        DecodedJWT verify = JwtConfig.verify(token);
//        map.put("studentId",verify.getClaim("studentId").asString());
        map.put("msg","请求成功");
        return map;
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
