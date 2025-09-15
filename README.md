# Back-Blog

一个基于Spring Boot的简单博客后端系统。

## 项目介绍

这是一个使用Spring Boot框架开发的博客后端系统，提供了基础的Web功能。项目采用了RESTful API设计风格，可以作为前后端分离架构中的后端服务。

## 技术栈

- **Spring Boot** 3.2.0
- **Java** 17
- **Maven** 构建工具
- **Lombok** 简化代码

## 项目结构

```
back-blog/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── backblog/
│   │   │               ├── config/
│   │   │               │   └── WebConfig.java
│   │   │               ├── controller/
│   │   │               │   └── HelloController.java
│   │   │               └── BackBlogApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── backblog/
├── pom.xml
└── README.md
```

## 快速开始

### 环境要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本

### 构建与运行

1. 克隆项目到本地

```bash
git clone <repository-url>
cd back-blog
```

2. 使用Maven构建项目

```bash
mvn clean package
```

3. 运行项目

```bash
java -jar target/back-blog-0.0.1-SNAPSHOT.jar
```

或者使用Maven直接运行

```bash
mvn spring-boot:run
```

4. 访问应用

打开浏览器访问 [http://localhost:8088](http://localhost:8088) 查看首页

API测试端点: [http://localhost:8088/api/hello](http://localhost:8088/api/hello)



## 配置说明

项目配置文件位于 `src/main/resources/application.yml`，主要配置如下：

```yaml
# 服务器配置
server:
  port: 8088

# Spring配置
spring:
  application:
    name: back-blog

# 日志配置
logging:
  level:
    org:
      springframework: INFO
    com:
      example:
        backblog: DEBUG
......
```

## 贡献指南

1. Fork 本仓库
2. 创建您的特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 打开一个 Pull Request

## 许可证

[MIT](https://opensource.org/licenses/MIT)

