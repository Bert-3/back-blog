package com.example.backblog.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * MyBatis-Plus 开发环境配置类
 */
@Configuration
@Profile({"dev", "test"}) // 仅在开发和测试环境生效
public class MybatisPlusDevConfig {

    /**
     * SQL 性能分析插件
     * 用于输出每条 SQL 语句及其执行时间
     */
    @Bean
    public MybatisPlusInterceptor performanceInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // SQL 检查插件，防止不规范SQL
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());

        return interceptor;
    }
}

