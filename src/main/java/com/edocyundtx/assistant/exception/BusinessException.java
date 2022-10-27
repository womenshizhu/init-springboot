package com.edocyundtx.assistant.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: 国际化类
 * Author:   Jack.Li
 * Time:     2021/5/6 14:56
 * Version:  1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private Integer code;
    private String message;
    private Object[] args;

    public BusinessException(Integer errorCode, String errorMessage, Object... args) {
        this.code = errorCode;
        this.message = errorMessage;
        if (args != null && args.length > 0) {
            this.args = args;
        }
    }

    public BusinessException() {
        this.code = -1;
        this.message = "报错信息未设置";
    }
}