package com.example.awesome.pojo.base;

/**
 * @author likang
 */

public enum ErrorCodeEnum {

    /**
     * 00000000 成功码，0100xxxx 错误码
     * 错误码后四位区分业务：
     *  0xxx:全局类错误码
     *  1xxx:用户类错误码
     *  2xxx:订单类错误码
     *  3xxx:商品类错误码
     */
    USERID_IS_NULL(ErrorCodeEnum.ERROR_CODE + 401,"用户ID为空！"),
    PARAM_IS_NULL(ErrorCodeEnum.ERROR_CODE + 402,"请求参数为空！"),
    PARAM_NOT_MATCH(ErrorCodeEnum.ERROR_CODE + 403,"请求的参数不匹配!"),
    NOT_FOUND(ErrorCodeEnum.ERROR_CODE + 404, "未找到该资源!"),

    SERVER_BUSY(ErrorCodeEnum.ERROR_CODE + 503,"服务器正忙，请稍后再试!"),
    INTERNAL_SERVER_ERROR(ErrorCodeEnum.ERROR_CODE + 500,"服务器内部错误!")
    ;

    /**
     * 错误码
     */
    private static final String ERROR_CODE = "01000";
//    /** 用户类错误码 **/
//    private static final String USER_CODE = "02000";
//    /** 订单类错误码 **/
//    private static final String ORDER_CODE = "03000";
//    /** 商品类错误码 **/
//    private static final String GOODS_CODE = "04000";

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    ErrorCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
