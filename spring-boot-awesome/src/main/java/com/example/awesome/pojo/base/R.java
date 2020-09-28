package com.example.awesome.pojo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ：R
 * @Description ：Restful响应实体类
 * @Author ：lkv587
 * @Date ：2020-08-19 17:31
 * @Version ：V1.0.0
 */
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 3819756348644158125L;

    /**
     * 返回状态：0 失败; 1 成功
     */
    private String status;

    /**
     * 状态码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T result;

    /**
     * 返回成功
     */
    private static final String SUCCESS = "1";

    /**
     * 返回成功码
     */
    private static final String SUCCESS_CODE = "00000000";
    /**
     * 返回失败
     */
    private static final String FAILED = "0";

    public R(){}

    private R(String status,String code,String message,T result){
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    private R(String status,String code,T result){
        this.status = status;
        this.code = code;
        this.result = result;
    }

    private R(String status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

    private R(String status, String code){
        this.status = status;
        this.code = code;
    }

    public R<T> Ok(){
        return new R<T>(SUCCESS,SUCCESS_CODE);
    }

    public R<T> Ok(T data){
        return new R<T>(SUCCESS,SUCCESS_CODE,data);
    }

    public R<T> Ok(String message,T result){
        return new R<T>(SUCCESS,SUCCESS_CODE,message,result);
    }

//    public R<T> Failed(String code, String message){
//        return new R<T>(FAILED,code,message);
//    }

    public R<T> Failed(ErrorCodeEnum errorCodeEnum){
        return new R<T>(FAILED,errorCodeEnum.getCode(),errorCodeEnum.getMessage());
    }

}
