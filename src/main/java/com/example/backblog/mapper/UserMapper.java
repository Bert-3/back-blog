package com.example.backblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backblog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper接口
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 可以在这里添加自定义的查询方法
}

