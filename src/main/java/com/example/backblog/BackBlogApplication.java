package com.example.backblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackBlogApplication {

    public static void main(String[] args) {
        System.out.println("启动成功");
        SpringApplication.run(BackBlogApplication.class, args);
    }
}

