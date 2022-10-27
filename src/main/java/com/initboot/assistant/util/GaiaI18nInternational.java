package com.initboot.assistant.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description: 国际化工具类
 * Author:   Jack.Li
 * Time:     2021/5/6 15:11
 * Version:  1.0.0
 */
@Component
public class GaiaI18nInternational {

    @Resource
    private HttpServletRequest request;
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String FILTER_PREFIX = "#";
    private static final String LANGUAGE_SEPARATOR = "-";

    /**
     * 获取国际化消息
     *
     * @param key  国际化的key
     * @param args 被替换占位符的值
     *             1.带#号的不是key的字符串，直接过滤#号
     *             2.是key的字符串，有占位符的替换
     *             3.不是key的字符串，返回字符串本身
     */
    public String getInterNationalMsg(String key, Object... args) {
        //带#号的不是key的字符串，直接过滤#号
        if (key.startsWith(FILTER_PREFIX)) {
            return key.substring(1);
        }
        ResourceBundle rb;
        String requestHeader = request.getHeader(ACCEPT_LANGUAGE);
        //是key的字符串，有占位符的替换
        try {
            //如en-US,zh-CN
            if (!StrUtil.isEmpty(requestHeader) && requestHeader.contains(LANGUAGE_SEPARATOR)) {
//                rb = ResourceBundle.getBundle("messages", new Locale(requestHeader.split(LANGUAGE_SEPARATOR)[0], requestHeader.split(LANGUAGE_SEPARATOR)[1]));
                rb = ResourceBundle.getBundle("i18n/messages", Locale.ENGLISH);
            } else {
                rb = ResourceBundle.getBundle("i18n/messages", Locale.CHINA);
            }
            return MessageFormat.format(rb.getString(key), args);
        } catch (Exception e) {
            //不是key的字符串，返回字符串本身
            return key;
        }
    }
}