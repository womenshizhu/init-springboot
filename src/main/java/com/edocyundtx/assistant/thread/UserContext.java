package com.edocyundtx.assistant.thread;

import com.edocyundtx.assistant.dto.UserInfo;

import java.util.Map;

/**
 * Description:
 * Author:   Jack.Li
 * Time:     2021/4/15 17:13
 * Version:  1.0.0
 */
public class UserContext {
    private static final ThreadLocal<UserInfo> USER_CONTENT = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> otherContext = new ThreadLocal<>();

    /**
     * 设置用户信息
     *
     * @param user -- 用户信息
     */
    public static void set(UserInfo user) {
        USER_CONTENT.set(user);
    }

    /**
     * 获取用户信息
     *
     * @return -- 用户信息
     */
    public static UserInfo get() {
        return USER_CONTENT.get();
    }

    /**
     * 移除用户信息
     */
    public static void remove() {
        USER_CONTENT.remove();
    }
}
