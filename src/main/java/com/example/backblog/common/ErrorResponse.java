package com.example.backblog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 错误响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /**
     * 时间戳
     */
    private LocalDateTime timestamp;

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 错误详情
     */
    private Map<String, String> errors;

    public ErrorResponse(Integer status, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ErrorResponse(Integer status, String message, String path, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }
}

