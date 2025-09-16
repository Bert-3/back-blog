package com.example.backblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backblog.common.Result;
import com.example.backblog.dto.UserDTO;
import com.example.backblog.entity.User;
import com.example.backblog.exception.BusinessException;
import com.example.backblog.exception.ResourceNotFoundException;
import com.example.backblog.security.MyAuthorize;
import com.example.backblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 获取用户列表
     * 只有管理员可以访问
     */
    @GetMapping
    @MyAuthorize({"ADMIN"})
    public Result<Page<UserDTO>> list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String keyword) {

        Page<User> page = new Page<>(current, size);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        // 如果有关键字，则按用户名、昵称或邮箱模糊查询
        if (keyword != null && !keyword.isEmpty()) {
            queryWrapper.like(User::getUsername, keyword)
                    .or().like(User::getNickname, keyword)
                    .or().like(User::getEmail, keyword);
        }

        // 按创建时间降序排序
        queryWrapper.orderByDesc(User::getCreatedAt);

        userService.page(page, queryWrapper);

        // 转换为DTO
        Page<UserDTO> dtoPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        List<UserDTO> dtoList = page.getRecords().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        dtoPage.setRecords(dtoList);

        return Result.success(dtoPage);
    }

    /**
     * 获取用户详情
     * 用户可以查看自己的信息，管理员可以查看所有用户的信息
     */
    @GetMapping("/{id}")
    @MyAuthorize({"USER", "ADMIN"})
    public Result<UserDTO> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return Result.success(convertToDTO(user));
    }

    /**
     * 创建用户
     * 只有管理员可以创建用户
     */
    @PostMapping
    @MyAuthorize({"ADMIN"})
    public Result<UserDTO> create(@RequestBody User user) {
        // 检查用户名是否已存在
        User existUser = userService.getByUsername(user.getUsername());
        if (existUser != null) {
            throw new BusinessException("用户名已存在");
        }

        // 检查邮箱是否已存在
        existUser = userService.getByEmail(user.getEmail());
        if (existUser != null) {
            throw new BusinessException("邮箱已存在");
        }

        // 设置默认值
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }

        // TODO: 密码加密处理

        boolean success = userService.save(user);
        if (!success) {
            throw new BusinessException("创建用户失败");
        }

        return Result.success(convertToDTO(user));
    }

    /**
     * 更新用户
     * 用户可以更新自己的信息，管理员可以更新所有用户的信息
     */
    @PutMapping("/{id}")
    @MyAuthorize({"USER", "ADMIN"})
    public Result<UserDTO> update(@PathVariable Long id, @RequestBody User user) {
        User existUser = userService.getById(id);
        if (existUser == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        user.setId(id);
        // 不允许修改用户名和邮箱
        user.setUsername(null);
        user.setEmail(null);
        // 不允许直接修改密码
        user.setPassword(null);

        boolean success = userService.updateById(user);
        if (!success) {
            throw new BusinessException("更新用户失败");
        }

        return Result.success(convertToDTO(userService.getById(id)));
    }

    /**
     * 删除用户
     * 只有管理员可以删除用户
     */
    @DeleteMapping("/{id}")
    @MyAuthorize({"ADMIN"})
    public Result<Void> delete(@PathVariable Long id) {
        User existUser = userService.getById(id);
        if (existUser == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        boolean success = userService.removeById(id);
        if (!success) {
            throw new BusinessException("删除用户失败");
        }

        return Result.success();
    }

    /**
     * 更新用户状态
     * 只有管理员可以更新用户状态
     */
    @PutMapping("/{id}/status")
    @MyAuthorize({"ADMIN"})
    public Result<Void> updateStatus(@PathVariable Long id, @RequestParam String status) {
        User existUser = userService.getById(id);
        if (existUser == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        // 验证状态值是否合法
        if (!status.equals("ACTIVE") && !status.equals("INACTIVE") && !status.equals("BANNED")) {
            throw new BusinessException("无效的状态值，只能是 ACTIVE、INACTIVE 或 BANNED");
        }

        boolean success = userService.updateStatus(id, status);
        if (!success) {
            throw new BusinessException("更新用户状态失败");
        }

        return Result.success();
    }

    /**
     * 将User实体转换为UserDTO
     */
    private UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        // 不返回密码
        return dto;
    }
}

