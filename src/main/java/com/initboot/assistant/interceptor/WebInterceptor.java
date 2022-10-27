package com.initboot.assistant.interceptor;


import com.initboot.assistant.dto.UserInfo;
import com.initboot.assistant.constant.ThreadConstant;
import com.initboot.assistant.thread.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 单点登录校验
 * Author:   fsli
 * Time:     2021/6/24 17:17
 * Version:  1.0.0
 */
@Slf4j
public class WebInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        log.info("add userInfo -- preHandleRequest");
        boolean isVaild = true;
//        校验jwt  Token
//        String authorization = request.getHeader("Authorization");
//        UserTO user = TokenVerification.getContextUserFromToken(authorization);
        UserInfo userInfo = new UserInfo();
        userInfo.setTenant("test");
        userInfo.setUsername("username");
        UserContext.set(userInfo);
        request.setAttribute(ThreadConstant.USER, userInfo);
        return isVaild;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(httpServletRequest, httpServletResponse, o, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {
//        log.info("remove userInfo -afterCompletionRequest");
        UserContext.remove();
        HandlerInterceptor.super.afterCompletion(httpServletRequest, httpServletResponse, o, e);
    }
}
