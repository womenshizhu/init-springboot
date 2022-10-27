package com.initboot.assistant.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 文档实体
 * Author:   Jack.Li
 * Time:     2021/4/23 14:05
 * Version:  1.0.0
 */
@Data
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 文档类型
     */
    private String docType;

    /**
     * 文档名称
     */
    private String docName;

    /**
     * 文档内容
     */
    private String docDetail;
}