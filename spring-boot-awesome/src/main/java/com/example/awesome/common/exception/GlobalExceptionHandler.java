package com.example.awesome.common.exception;

import com.example.awesome.common.constant.ResultEntity;
import com.example.awesome.common.emun.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ：GlobalExceptionHandler
 * @Description ：统一异常处理
 * @Author ：lkv587
 * @Date ：2020-08-20 14:20
 * @Version ：V1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务自定义异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultEntity bizExceptionHandler(HttpServletRequest request,BizException e){
        log.error("发生业务异常，原因是：",e.getMsg());
        return ResultEntity.failed(e.getCode(),e.getMsg());
    }

    /**
     * 空指针异常处理
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultEntity exceptionHandler(HttpServletRequest request,NullPointerException e){
        log.error("发生空指针异常，原因：",e.getMessage());
        return ResultEntity.failed(ErrorEnum.PARAM_NOT_MATCH);
    }

    /**
     * 其他异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity exceptionHandler(HttpServletRequest request,Exception e){
        log.error("未知异常，原因：",e.getMessage());
        return ResultEntity.failed(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
