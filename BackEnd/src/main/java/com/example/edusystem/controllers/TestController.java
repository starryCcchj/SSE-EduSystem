package com.example.edusystem.controllers;


import com.example.edusystem.tools.MailUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试SWAGGER")
@RequestMapping("test")
public class TestController {

    @Autowired
    private MailUtils mailUtils;

    @GetMapping("test")
    public String test() {
        return "testSwagger";
    }

    @GetMapping("email")
    public String sendEmail() {
        String to = "1361021809@qq.com";
        String subject = "TEST";
        String content = "今晚要写软工，嘿嘿嘿，我的软工嘿嘿，软工嘿嘿";
        mailUtils.sendSimpleMail(to, subject, content);


        return "已尝试发送";
    }
}
