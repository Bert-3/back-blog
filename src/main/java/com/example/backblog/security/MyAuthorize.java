package com.example.backblog.security;

import java.lang.annotation.*;

/**
 * 自定义权限注解
 * 用于标记需要特定角色才能访问的接口
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAuthorize {
    /**
     * 允许访问的角色列表
     */
    String[] value() default {};
}

