package com.initboot.assistant.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.initboot.assistant.thread.UserContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Description: 字段映射处理器
 * Author:   Jack.Li
 * Time:     2021/11/10 13:53
 * Version:  1.0.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createUser", UserContext.get().getPersonId(), metaObject);
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("lastUpdateUser", UserContext.get().getPersonId(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
