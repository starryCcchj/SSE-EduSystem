package com.example.edusystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.edusystem.mapper")
@SpringBootApplication
public class SseEduSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SseEduSystemApplication.class, args);
    }

}
