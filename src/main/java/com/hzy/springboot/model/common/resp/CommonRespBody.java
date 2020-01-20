package com.hzy.springboot.model.common.resp;

import com.hzy.springboot.enums.CommonError;
import com.hzy.springboot.exception.ApiException;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CommonRespBody<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public CommonRespBody(T data) {
        this();
        this.data = data;
    }

    public CommonRespBody() {
        this.code = "200";
        this.msg = "SUCCESS";
    }

    public CommonRespBody(ApiException apiException) {
        this.code = apiException.getCode();
        this.msg = apiException.getMsg();
    }

    public CommonRespBody(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CommonRespBody(CommonError commonError) {
        this.code = commonError.getCode();
        this.msg = commonError.getMsg();
    }
}
