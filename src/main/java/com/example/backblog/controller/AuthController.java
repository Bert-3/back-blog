package com.example.backblog.controller;

import com.example.backblog.common.Result;
import com.example.backblog.entity.User;
import com.example.backblog.exception.BusinessException;
import com.example.backblog.security.JwtUtils;
import com.example.backblog.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
        // 查询用户
        User user = userService.getByUsername(username);
        if (user == null) {
            throw new BusinessException("用户名不存在");
        }

        // 验证密码
        //TODO 登陆逻辑

        // 检查用户状态
        if (!"ACTIVE".equals(user.getStatus())) {
            throw new BusinessException("账号已被禁用");
        }

        // 生成Token
        String token = jwtUtils.generateToken(user);

        // 返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", user);

        return Result.success(result);
    }
}

