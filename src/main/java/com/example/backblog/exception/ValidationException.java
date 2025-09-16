package com.example.backblog.exception;

import java.util.Map;

/**
 * 参数验证异常
 */
public class ValidationException extends BusinessException {

    private final Map<String, String> errors;

    public ValidationException(String message) {
        super(422, message);
        this.errors = null;
    }

    public ValidationException(String message, Map<String, String> errors) {
        super(422, message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}

