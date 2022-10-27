package com.initboot.assistant.enums;

import lombok.Getter;

/**
 * Description: 异常枚举
 * Author:   Jack.Li
 * Time:     2021/5/6 15:23
 * Version:  1.0.0
 */
@Getter
public enum ExceptionEnum {
    //异常类型,添加枚举时，应该在i18n中添加对应的中英文转换
    DEMO_EXCEPTION(10001, "DEMO_EXCEPTION"),
    ;
    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
