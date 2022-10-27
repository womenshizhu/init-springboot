package com.edocyundtx.assistant.annotation;

import java.lang.annotation.*;

/**
 * Description: 忽略api结果处理
 * Author:   Jack.Li
 * Time:     2021/5/6 16:28
 * Version:  1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiResultIgnore {
}
