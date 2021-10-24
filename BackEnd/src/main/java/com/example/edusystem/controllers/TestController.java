package com.example.edusystem.controllers;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试SWAGGER")
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return  "testSwagger";
    }
}
