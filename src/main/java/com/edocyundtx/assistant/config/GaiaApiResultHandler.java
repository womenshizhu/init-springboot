package com.edocyundtx.assistant.config;

import com.edocyundtx.assistant.annotation.ApiResultIgnore;
import com.edocyundtx.assistant.dto.ResultData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * Description: api结果封装
 * Author:   Jack.Li
 * Time:     2021/5/6 16:26
 * Version:  1.0.0
 */
@ControllerAdvice
public class GaiaApiResultHandler implements ResponseBodyAdvice {

    @Autowired
    private HttpServletRequest request;

    private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);
    private static final Class[] ANNOS = new Class[]{RequestMapping.class, GetMapping.class, PostMapping.class, DeleteMapping.class, PutMapping.class};
    private static final Class IGNORE = ApiResultIgnore.class;

    public GaiaApiResultHandler() {
    }

    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter, MediaType mediaType, Class clas, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ObjectMapper mapper = (ObjectMapper)this.mapperThreadLocal.get();
        if (returnValue instanceof String) {
            try {
                Object strObject = mapper.writeValueAsString(ResultData.ok(request,returnValue));
                serverHttpResponse.getHeaders().setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
                return strObject;
            } catch (JsonProcessingException var9) {
                var9.printStackTrace();
            }
        }
        return ResultData.ok(request,returnValue);
    }

    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        if (!returnType.getContainingClass().toString().contains("edocyundtx")) {
            return false;
        } else {
            return element.isAnnotationPresent(IGNORE) ? false : Arrays.stream(ANNOS).anyMatch((anno) -> {
                return anno.isAnnotation() && element.isAnnotationPresent(anno);
            });
        }
    }
}
