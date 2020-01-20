package com.hzy.springboot.enums;

public enum UserError implements CommonError {
    ERROR("500","服务器开小差了，请稍后重试！"),
    NULLPOINTEXCEPTION("501","空指针异常！"),
    REQUEST_NOT_NULL("10001","参数不能为空！"),
    USER_NOT_EXIST("10002","用户不存在！"),
    PASSWORD_ERROR("10003","密码错误！"),
    ;

    private String code;
    private String msg;

    UserError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
