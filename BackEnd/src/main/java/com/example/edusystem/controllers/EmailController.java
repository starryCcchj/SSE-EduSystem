package com.example.edusystem.controllers;

import com.example.edusystem.tools.MailUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(tags = "邮件验证Part")
@RequestMapping("verify")
public class EmailController {

    @Autowired
    private MailUtils mailUtils;

    @GetMapping("email")
    public String sendSimpleEmail(String to,String subject,String content)  {

        mailUtils.sendSimpleMail(to, subject, content);
        return "已尝试发送";
    }




    @GetMapping("verifycode")
    public String getVerifyCode()
    {
        return "暂时没有想好怎么写！";
    }

}
