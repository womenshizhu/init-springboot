package com.initboot.assistant.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: 测试用户
 * Author:   fsli
 * Time:     2021/5/29 17:17
 * Version:  1.0.0
 */
@Data
@TableName(value = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    @NotBlank(message = "名字不能为空")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 测试驼峰
     */
    @TableField(value = "test_camel")
    private String test_camel;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 最后修改人
     */
    @TableField(value = "last_update_user", fill = FieldFill.UPDATE)
    private String lastUpdateUser;

    /**
     * 最后修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}