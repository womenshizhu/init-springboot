package com.edocyundtx.assistant.dto;

import lombok.Data;

/**
 * Description: 用户基础信息
 * Author:   Jack.Li
 * Time:     2021/6/24 9:39
 * Version:  1.0.0
 */
@Data
public class UserInfo {

    private String tenant;

    private String username;

    private String personId;
}
