package com.edocyundtx.assistant.config;

import com.edocyundtx.assistant.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


/**
 * Description: 拦截器处理threadLocal
 * Author:   Jack.Li
 * Time:     2021/6/24 9:39
 * Version:  1.0.0
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/api/**").addPathPatterns("/signout").addPathPatterns("/signin-oauth").excludePathPatterns(getExcludeURLList());
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new CrosInterceptor()).addPathPatterns("/**");
    }

    private static List<String> getExcludeURLList() {
        List<String> urlList = new ArrayList<>();
        urlList.add("/api/v1/invokingTask/**");
        return urlList;
    }
}
