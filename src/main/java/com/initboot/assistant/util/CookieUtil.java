package com.initboot.assistant.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;


public class CookieUtil {
    public static Cookie setCookie(HttpServletResponse respose, String key, String value, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        respose.addCookie(cookie);
        return cookie;
    }


    public static Cookie getCookie(HttpServletRequest httpServletRequest, String name) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {

            Optional<Cookie> result = Arrays.stream(cookies).filter(t -> t.getName().equals(name)).findFirst();
            if (result.isPresent()) {
                return (Cookie) result.get();
            }
        }
        return null;
    }
}


