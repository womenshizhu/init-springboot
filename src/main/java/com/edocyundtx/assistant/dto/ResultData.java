package com.edocyundtx.assistant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public final class ResultData implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8682197313509107658L;

    @ApiModelProperty(value = "状态", position = 0)
    private boolean result;

    @ApiModelProperty(value = "返回码", position = 1)
    private Integer errorCode;

    @ApiModelProperty(value = "消息", position = 2)
    private String errorMsg;

    @ApiModelProperty(value = "数据", position = 3)
    private Object data;


    private ResultData(boolean result, Integer errorCode, String errorMsg) {
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private ResultData(boolean result, Integer errorCode, String errorMsg, Object data) {
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }


    public static ResultData ok(HttpServletRequest request) {
        return new ResultData(true, 200, "success");
    }

    public static ResultData ok(HttpServletRequest request, Object data) {
        return new ResultData(true, 200, "success", data);
    }

    public static ResultData error(HttpServletRequest request, Integer code, String message) {
        return new ResultData(false, code, message);
    }

    public static ResultData error(HttpServletRequest request) {
        return new ResultData(false, 500, "fail");
    }

    public static ResultData error(Integer code, String message) {
        return new ResultData(false, code, message);
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
