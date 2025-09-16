package com.example.backblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backblog.common.Result;
import com.example.backblog.entity.User;

/**
 * 用户服务接口
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User getByUsername(String username);

    /**
     * 根据邮箱查询用户
     * @param email 邮箱
     * @return 用户对象
     */
    User getByEmail(String email);

    /**
     * 更新用户状态
     * @param userId 用户ID
     * @param status 状态
     * @return 是否成功
     */
    boolean updateStatus(Long userId, String status);

    Result login(String username, String password);

}

