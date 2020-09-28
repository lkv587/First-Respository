package com.example.awesome.common.emun;

import com.example.awesome.common.exception.BaseErrorInfoServer;

public enum ErrorEnum implements BaseErrorInfoServer {

    SUCCESS("0000000","请求成功！"),
    USERID_IS_NULL(ErrorEnum.ERROR_CODE + 401,"用户ID为空！"),
    PARAM_IS_NULL(ErrorEnum.ERROR_CODE + 402,"请求参数为空！"),
    PARAM_NOT_MATCH(ErrorEnum.ERROR_CODE + 403,"请求的参数不匹配!"),
    NOT_FOUND(ErrorEnum.ERROR_CODE + 404, "未找到该资源!"),
    SESSION_VALID(ErrorEnum.ERROR_CODE + 405, "session失效!"),
    SERVER_BUSY(ErrorEnum.ERROR_CODE + 503,"服务器正忙，请稍后再试!"),
    INTERNAL_SERVER_ERROR(ErrorEnum.ERROR_CODE + 500,"服务器内部错误!")
    ;

    private static final String ERROR_CODE = "01000";

    private String code;

    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
