package com.example.awesome.common.exception;

/**
 * @ClassName ：BizException
 * @Description ：自定义异常
 * @Author ：lkv587
 * @Date ：2020-08-20 13:25
 * @Version ：V1.0.0
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 7318146874023871278L;

    private String code;

    private String msg;


    public BizException(){
        super();
    }

    public BizException(BaseErrorInfoServer errorInfoServer){
        super(errorInfoServer.getCode());
        this.code = errorInfoServer.getCode();
        this.msg = errorInfoServer.getMessage();
    }

    public BizException(BaseErrorInfoServer errorInfoServer,Throwable throwable){
        super(errorInfoServer.getCode(),throwable);
        this.code = errorInfoServer.getCode();
        this.msg = errorInfoServer.getMessage();
    }

    public BizException(String msg){
        super(msg);
        this.msg = msg;
    }

    public BizException(String code,String msg){
        super(code);
        this.code = code;
        this.msg = msg;
    }

    public BizException(String code,String msg,Throwable throwable){
        super(code,throwable);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
