package com.initboot.assistant.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: URL变量替换工具类   url中替换{tenant}
 * Author:   Jack.Li
 * Time:     2021/5/6 15:11
 * Version:  1.0.0
 */

@Component
public class HttpUrlUtil {

    public static String parseUrl(String url, Map<String, Object> paramsMap) {
        Map<String, String> replaceFields = getUrlReplaceField(url);
        Map<String, String> replaceInfo = new HashMap<>();
        for (Map.Entry<String, String> entry : replaceFields.entrySet()) {
            Object paramValue = paramsMap.get(entry.getKey());
            String value = "";
            if (paramValue != null) {
                value = String.valueOf(paramsMap.get(entry.getKey()));
            }
            replaceInfo.put(entry.getValue(), value);
        }
        for (Map.Entry<String, String> entry : replaceInfo.entrySet()) {
            url = StrUtil.replace(url, entry.getKey(), entry.getValue());
        }
        return url;
    }


    private static Map<String, String> getUrlReplaceField(Map<String, String> replaceFields, String url) {
        int startIndex = url.indexOf("{");
        int endIndex = url.indexOf("}") + 1;
        if (startIndex > -1 || endIndex > 0) {
            String field = url.substring(startIndex, endIndex);
            String key = field.substring(1, field.length() - 1);
            replaceFields.put(key, field);
            if (endIndex + 1 <= url.length()) {
                getUrlReplaceField(replaceFields, url.substring(endIndex + 1));
            }
        }
        return replaceFields;
    }

    private static Map<String, String> getUrlReplaceField(String url) {
        Map<String, String> replaceFields = new HashMap<>();
        replaceFields = getUrlReplaceField(replaceFields, url);
        return replaceFields;

    }

    public static void main(String[] args) {
        String url = "/api/v1/noticeCenter/noticeDetail/{tenant}/getAnnounceNoticeListForPortal?pageSize={pageSize}&pageNum={pageNum}";
//        String url = "/api/v1/noticeCenter/noticeDetail/{tenant}/getAnnounceNoticeListForPortal?pageSize=10&pageNum=1";
        Map<String, Object> param = new HashMap<>();
        param.put("tenant", "test");
        param.put("pageSize", "10");
        param.put("pageNum", "1");
        url = HttpUrlUtil.parseUrl(url, param);
        System.out.println(url);
    }
}
