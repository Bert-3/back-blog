package com.example.backblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backblog.common.Result;
import com.example.backblog.constants.UserStatusConstants;
import com.example.backblog.entity.User;
import com.example.backblog.enums.StatusEnums;
import com.example.backblog.mapper.UserMapper;
import com.example.backblog.service.UserService;
import com.example.backblog.util.BCryptPasswordUtil;
import com.example.backblog.util.JwtUtils;
import com.example.backblog.vo.LoginVo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private BCryptPasswordUtil bCryptPasswordUtil;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public User getByUsername(String username) {
        return getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username));
    }

    @Override
    public User getByEmail(String email) {
        return getOne(new LambdaQueryWrapper<User>()
                .eq(User::getEmail, email));
    }

    @Override
    public boolean updateStatus(Long userId, String status) {
        User user = new User();
        user.setId(userId);
        user.setStatus(status);
        return updateById(user);
    }

    @Override
    public Result login(String username, String password) {
        User user = lambdaQuery()
                .eq(username != null, User::getUsername, username)
                .one();
        if (user == null) {
            return Result.error(StatusEnums.USER_NOT_FOUND.getCode(),StatusEnums.USER_NOT_FOUND.getMessage());
        }
        if (!bCryptPasswordUtil.matches(password, user.getPassword())) {
            return Result.error(StatusEnums.USERNAME_OR_PASSWORD_ERROR.getCode(),StatusEnums.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }
        if (!user.getStatus().equals(UserStatusConstants.ACTIVE)) {
            return Result.error(StatusEnums.ACCOUNT_LOCKED.getCode(),StatusEnums.ACCOUNT_LOCKED.getMessage());
        }
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(jwtUtils.generateToken(user));
        loginVo.setRole(user.getRole());
        return Result.success(loginVo);
    }
}

