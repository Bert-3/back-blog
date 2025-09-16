package com.example.backblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.backblog.mapper")
public class BackBlogApplication {

    public static void main(String[] args) {
        System.out.println("启动成功");
        SpringApplication.run(BackBlogApplication.class, args);
    }
}

