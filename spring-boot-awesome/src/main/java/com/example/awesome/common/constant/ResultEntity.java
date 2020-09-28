package com.example.awesome.common.constant;

import com.example.awesome.common.emun.ErrorEnum;
import com.example.awesome.common.exception.BaseErrorInfoServer;

import java.io.Serializable;

/**
 * @ClassName ：ResultEntity
 * @Description ：返回实体
 * @Author ：lkv587
 * @Date ：2020-08-20 13:47
 * @Version ：V1.0.0
 */
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = 3792260660595366339L;

    private String status;

    private String code;

    private String message;

    private Object data;

    public ResultEntity(){}

    public ResultEntity(BaseErrorInfoServer errorInfoServer){
        this.code = errorInfoServer.getCode();
        this.message = errorInfoServer.getMessage();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultEntity success(Object object){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus("1");
        resultEntity.setCode(ErrorEnum.SUCCESS.getCode());
        resultEntity.setMessage(ErrorEnum.SUCCESS.getMessage());
        resultEntity.setData(object);
        return resultEntity;
    }

    public static ResultEntity failed(String code,String message){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus("0");
        resultEntity.setCode(code);
        resultEntity.setMessage(message);
        return resultEntity;
    }

    public static ResultEntity failed(BaseErrorInfoServer errorInfoServer){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setStatus("0");
        resultEntity.setCode(errorInfoServer.getCode());
        resultEntity.setMessage(errorInfoServer.getMessage());
        return resultEntity;
    }

}
