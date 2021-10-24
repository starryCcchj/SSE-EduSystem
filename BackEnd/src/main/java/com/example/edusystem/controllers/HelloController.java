package com.example.edusystem.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* 类注解 */
@Api(value = "desc of class")
@RestController
public class HelloController {

//    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value="/hello")
    public String hello(String target){
        //访问数据库
        //拿到数据库数据，进行一定的格式处理
        //return给前端
        return  "Hello World!";
    }

    @PostMapping(value = "/post")
    public String postTest(){
        return "postTest";
    }
}
