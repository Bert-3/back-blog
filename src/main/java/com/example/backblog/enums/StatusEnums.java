package com.example.backblog.enums;

import lombok.Getter;

/**
 * 状态码枚举
 * 包含HTTP状态码和业务状态码
 */
@Getter
public enum StatusEnums {
    
    // 成功状态码
    SUCCESS(200, "操作成功"),
    CREATED(201, "创建成功"),
    ACCEPTED(202, "请求已接受"),
    NO_CONTENT(204, "操作成功但无返回内容"),
    PARTIAL_CONTENT(206, "部分内容"),

    // 重定向状态码
    MULTIPLE_CHOICES(300, "多种选择"),
    MOVED_PERMANENTLY(301, "永久重定向"),
    FOUND(302, "临时重定向"),
    SEE_OTHER(303, "查看其他位置"),
    NOT_MODIFIED(304, "资源未修改"),
    TEMPORARY_REDIRECT(307, "临时重定向"),
    PERMANENT_REDIRECT(308, "永久重定向"),

    // 客户端错误状态码
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权，请先登录"),
    PAYMENT_REQUIRED(402, "需要付款"),
    FORBIDDEN(403, "权限不足，禁止访问"),
    NOT_FOUND(404, "请求的资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    NOT_ACCEPTABLE(406, "不接受的请求"),
    PROXY_AUTHENTICATION_REQUIRED(407, "需要代理认证"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "资源冲突，操作无法完成"),
    GONE(410, "请求的资源已被永久移除"),
    LENGTH_REQUIRED(411, "需要Content-Length头"),
    PRECONDITION_FAILED(412, "前提条件失败"),
    PAYLOAD_TOO_LARGE(413, "请求实体过大"),
    URI_TOO_LONG(414, "请求URI过长"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    RANGE_NOT_SATISFIABLE(416, "请求范围不符合要求"),
    EXPECTATION_FAILED(417, "预期失败"),
    UNPROCESSABLE_ENTITY(422, "无法处理的实体"),
    LOCKED(423, "资源被锁定"),
    TOO_MANY_REQUESTS(429, "请求过于频繁，请稍后再试"),

    // 服务端错误状态码
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "服务未实现"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP版本不支持"),
    VARIANT_ALSO_NEGOTIATES(506, "变体也可协商"),
    INSUFFICIENT_STORAGE(507, "存储空间不足"),
    LOOP_DETECTED(508, "检测到循环"),
    NOT_EXTENDED(510, "未扩展"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "需要网络认证"),

    // 业务状态码 (1000-1999: 用户相关)
    USER_NOT_FOUND(1001, "用户不存在"),
    USER_ALREADY_EXISTS(1002, "用户已存在"),
    USERNAME_OR_PASSWORD_ERROR(1003, "用户名或密码错误"),
    ACCOUNT_LOCKED(1004, "账号已被锁定"),
    ACCOUNT_DISABLED(1005, "账号已被禁用"),
    PASSWORD_EXPIRED(1006, "密码已过期，请修改密码"),
    INVALID_TOKEN(1007, "无效的令牌"),
    TOKEN_EXPIRED(1008, "令牌已过期"),
    USER_REGISTRATION_FAILED(1009, "用户注册失败"),
    EMAIL_ALREADY_EXISTS(1010, "邮箱已被使用"),
    PHONE_ALREADY_EXISTS(1011, "手机号已被使用"),
    VERIFICATION_CODE_ERROR(1012, "验证码错误"),
    VERIFICATION_CODE_EXPIRED(1013, "验证码已过期"),
    PASSWORD_RESET_FAILED(1014, "密码重置失败"),
    ACCOUNT_NOT_ACTIVATED(1015, "账号未激活"),
    LOGIN_FAILED(1016, "登录失败"),
    LOGOUT_FAILED(1017, "登出失败"),
    ROLE_NOT_FOUND(1018, "角色不存在"),
    PERMISSION_DENIED(1019, "权限不足"),

    // 业务状态码 (2000-2999: 文章相关)
    ARTICLE_NOT_FOUND(2001, "文章不存在"),
    ARTICLE_ALREADY_EXISTS(2002, "文章已存在"),
    ARTICLE_ALREADY_PUBLISHED(2003, "文章已发布"),
    ARTICLE_ALREADY_DELETED(2004, "文章已删除"),
    ARTICLE_CONTENT_EMPTY(2005, "文章内容不能为空"),
    ARTICLE_TITLE_EMPTY(2006, "文章标题不能为空"),
    ARTICLE_CATEGORY_NOT_FOUND(2007, "文章分类不存在"),
    ARTICLE_TAG_NOT_FOUND(2008, "文章标签不存在"),
    ARTICLE_PUBLISH_FAILED(2009, "文章发布失败"),
    ARTICLE_UPDATE_FAILED(2010, "文章更新失败"),
    ARTICLE_DELETE_FAILED(2011, "文章删除失败"),
    ARTICLE_LIKE_FAILED(2012, "文章点赞失败"),
    ARTICLE_UNLIKE_FAILED(2013, "文章取消点赞失败"),
    ARTICLE_FAVORITE_FAILED(2014, "文章收藏失败"),
    ARTICLE_UNFAVORITE_FAILED(2015, "文章取消收藏失败"),

    // 业务状态码 (3000-3999: 评论相关)
    COMMENT_NOT_FOUND(3001, "评论不存在"),
    COMMENT_ALREADY_DELETED(3002, "评论已删除"),
    COMMENT_CONTENT_EMPTY(3003, "评论内容不能为空"),
    COMMENT_CREATE_FAILED(3004, "评论创建失败"),
    COMMENT_UPDATE_FAILED(3005, "评论更新失败"),
    COMMENT_DELETE_FAILED(3006, "评论删除失败"),
    COMMENT_LIKE_FAILED(3007, "评论点赞失败"),
    COMMENT_UNLIKE_FAILED(3008, "评论取消点赞失败"),
    COMMENT_REPLY_FAILED(3009, "评论回复失败"),

    // 业务状态码 (4000-4999: 分类和标签相关)
    CATEGORY_NOT_FOUND(4001, "分类不存在"),
    CATEGORY_ALREADY_EXISTS(4002, "分类已存在"),
    TAG_NOT_FOUND(4003, "标签不存在"),
    TAG_ALREADY_EXISTS(4004, "标签已存在"),
    CATEGORY_CREATE_FAILED(4005, "分类创建失败"),
    CATEGORY_UPDATE_FAILED(4006, "分类更新失败"),
    CATEGORY_DELETE_FAILED(4007, "分类删除失败"),
    TAG_CREATE_FAILED(4008, "标签创建失败"),
    TAG_UPDATE_FAILED(4009, "标签更新失败"),
    TAG_DELETE_FAILED(4010, "标签删除失败"),

    // 业务状态码 (5000-5999: 文件上传相关)
    FILE_UPLOAD_FAILED(5001, "文件上传失败"),
    FILE_SIZE_EXCEEDED(5002, "文件大小超出限制"),
    FILE_TYPE_NOT_SUPPORTED(5003, "不支持的文件类型"),
    FILE_NOT_FOUND(5004, "文件不存在"),
    FILE_DOWNLOAD_FAILED(5005, "文件下载失败"),
    FILE_DELETE_FAILED(5006, "文件删除失败"),
    FILE_EMPTY(5007, "文件为空"),
    FILE_CORRUPTED(5008, "文件已损坏"),
    IMAGE_PROCESS_FAILED(5009, "图片处理失败"),

    // 业务状态码 (6000-6999: 搜索相关)
    SEARCH_FAILED(6001, "搜索失败"),
    SEARCH_PARAM_ERROR(6002, "搜索参数错误"),
    INDEX_NOT_FOUND(6003, "索引不存在"),
    INDEX_CREATE_FAILED(6004, "索引创建失败"),
    INDEX_UPDATE_FAILED(6005, "索引更新失败"),
    INDEX_DELETE_FAILED(6006, "索引删除失败"),

    // 业务状态码 (7000-7999: 第三方服务相关)
    THIRD_PARTY_SERVICE_ERROR(7001, "第三方服务错误"),
    API_CALL_LIMIT_EXCEEDED(7002, "API调用次数超出限制"),
    PAYMENT_FAILED(7003, "支付失败"),
    SMS_SEND_FAILED(7004, "短信发送失败"),
    EMAIL_SEND_FAILED(7005, "邮件发送失败"),
    OAUTH_ERROR(7006, "OAuth认证错误"),

    // 业务状态码 (8000-8999: 数据库相关)
    DATABASE_ERROR(8001, "数据库错误"),
    DATA_INTEGRITY_VIOLATION(8002, "数据完整性违反"),
    TRANSACTION_FAILED(8003, "事务执行失败"),
    QUERY_TIMEOUT(8004, "查询超时"),
    CONNECTION_FAILED(8005, "数据库连接失败"),

    // 业务状态码 (9000-9999: 系统相关)
    SYSTEM_ERROR(9001, "系统错误"),
    OPERATION_FAILED(9002, "操作失败"),
    PARAM_ERROR(9003, "参数错误"),
    DATA_ERROR(9004, "数据错误"),
    VALIDATION_ERROR(9005, "数据验证错误"),
    RATE_LIMIT_EXCEEDED(9006, "请求频率超出限制"),
    MAINTENANCE_MODE(9007, "系统维护中"),
    SERVICE_DEGRADATION(9008, "服务降级"),
    CIRCUIT_BREAKER_OPEN(9009, "熔断器开启"),
    UNKNOWN_ERROR(9999, "未知错误");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String message;

    /**
     * 构造方法
     *
     * @param code    状态码
     * @param message 状态信息
     */
    StatusEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据状态码获取状态枚举
     *
     * @param code 状态码
     * @return 状态枚举
     */
    public static StatusEnums getByCode(int code) {
        for (StatusEnums statusEnum : StatusEnums.values()) {
            if (statusEnum.getCode() == code) {
                return statusEnum;
            }
        }
        return UNKNOWN_ERROR;
    }
}
