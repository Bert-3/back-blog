package com.example.backblog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * BCrypt密码加密工具类
 * 专注于提供BCrypt加密算法的功能
 */
@Component
public class BCryptPasswordUtil {

    private final BCryptPasswordEncoder encoder;

    /**
     * 默认构造函数，使用默认强度(10)
     */
    public BCryptPasswordUtil() {
        this.encoder = new BCryptPasswordEncoder();
    }

    /**
     * 自定义强度的构造函数
     *
     * @param strength 加密强度，范围4-31，默认为10
     */
    public BCryptPasswordUtil(int strength) {
        this.encoder = new BCryptPasswordEncoder(strength);
    }

    /**
     * 使用BCrypt加密密码
     *
     * @param rawPassword 原始密码
     * @return 加密后的密码
     */
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * 验证密码是否匹配
     *
     * @param rawPassword 原始密码
     * @param encodedPassword 加密后的密码
     * @return 是否匹配
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 检查加密后的密码是否需要升级
     * 当BCrypt的实现或强度参数发生变化时，可以用此方法检查是否需要重新加密
     *
     * @param encodedPassword 加密后的密码
     * @return 是否需要升级
     */
    public boolean upgradeEncoding(String encodedPassword) {
        return encoder.upgradeEncoding(encodedPassword);
    }
}

