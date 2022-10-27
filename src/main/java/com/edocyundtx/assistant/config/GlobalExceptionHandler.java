package com.edocyundtx.assistant.config;

import com.edocyundtx.assistant.dto.ResultData;
import com.edocyundtx.assistant.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * Description: 全局异常处理
 * Author:   Jack.Li
 * Time:     2021/5/6 16:12
 * Version:  1.0.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResultData handleBusinessException(BusinessException e) {
        log.error("业务异常", e);
        return ResultData.error(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public ResultData handleSQLException(SQLException e) {
        log.error("Sql异常", e);
        return ResultData.error(500, "Sql异常:" + e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数非法异常", e);
        return ResultData.error(400, "请求参数异常:" + e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
