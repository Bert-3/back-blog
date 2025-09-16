package com.example.backblog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 */
@Tag(name = "测试接口", description = "用于测试Knife4j集成的接口")
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * 测试接口
     *
     * @param name 姓名
     * @return 测试结果
     */
    @Operation(summary = "测试接口", description = "返回一个简单的问候消息")
    @GetMapping("/hello")
    public Map<String, Object> hello(
            @Parameter(description = "姓名", required = true) @RequestParam String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "Hello, " + name + "!");
        result.put("data", null);
        return result;
    }
}

