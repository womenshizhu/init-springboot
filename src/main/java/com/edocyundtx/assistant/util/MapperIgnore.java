package com.edocyundtx.assistant.util;

/**
 * Description:
 * Author:   lifusheng
 * Time:     2019/10/30 9:56
 * Version:  1.0.0
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperIgnore {
}
