package com.hzy.springboot.exception;

import com.hzy.springboot.enums.CommonError;
import lombok.Data;

@Data
public class   ApiException extends RuntimeException{
    private String code;
    private String msg;

    public ApiException() {
        super();
    }

    public ApiException(CommonError commonError) {
        this.code = commonError.getCode();
        this.msg = commonError.getMsg();
    }
}
