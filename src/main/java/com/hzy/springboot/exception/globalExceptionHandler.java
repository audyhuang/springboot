package com.hzy.springboot.exception;

import com.hzy.springboot.enums.UserError;
import com.hzy.springboot.model.common.resp.CommonRespBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class globalExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonRespBody<Object> ExcetionHandler(HttpServletRequest request, Exception ex){
        log.error("请求方法：{}，错误原因：{}",request.getRequestURI(),ex.getMessage());
        if(ex instanceof ApiException){
            return new CommonRespBody(ex);
        }
        log.error("<------------------------全局异常捕获成功！------------------------>");
        return new CommonRespBody<>(UserError.ERROR);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonRespBody NullPointExceptionHandler(HttpServletRequest request, NullPointerException ex){
        log.error("<-----------------空指针异常：NullPointException----------------->");
        log.error("请求方法：{}，错误原因：{}",request.getRequestURI(),ex.getMessage());
        return new CommonRespBody(UserError.NULLPOINTEXCEPTION);
    }
}
