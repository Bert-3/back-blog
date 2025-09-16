package com.example.backblog.security;

import com.example.backblog.exception.ForbiddenException;
import com.example.backblog.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

/**
 * 权限拦截器
 */
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是处理方法，直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 获取方法上的注解
        MyAuthorize methodAnnotation = handlerMethod.getMethodAnnotation(MyAuthorize.class);
        // 获取类上的注解
        MyAuthorize classAnnotation = handlerMethod.getBeanType().getAnnotation(MyAuthorize.class);

        // 如果方法和类上都没有注解，则不需要权限验证
        if (methodAnnotation == null && classAnnotation == null) {
            return true;
        }

        // 获取当前用户角色
        String role = (String) request.getAttribute("role");

        // 如果用户未登录
        if (role == null) {
            throw new UnauthorizedException("请先登录");
        }

        // 如果是管理员，直接放行
        if ("ADMIN".equals(role)) {
            return true;
        }

        // 获取允许访问的角色列表
        String[] allowedRoles = methodAnnotation != null ? methodAnnotation.value() : classAnnotation.value();

        // 检查用户角色是否在允许的角色列表中
        if (allowedRoles.length > 0 && !Arrays.asList(allowedRoles).contains(role)) {
            log.warn("用户 [{}] 尝试访问需要 {} 角色的资源", request.getAttribute("username"), Arrays.toString(allowedRoles));
            throw new ForbiddenException("您没有权限访问此资源");
        }

        return true;
    }
}

