package com.example.backblog.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户数据传输对象
 */
@Data
public class UserDTO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 个人简介
     */
    private String bio;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 用户显示标签
     */
    private String displayTag;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}

