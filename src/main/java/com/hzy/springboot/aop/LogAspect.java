package com.hzy.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.hzy.springboot.controller.*.*(..))")
    public void controllerLog(){
    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint){
        log.info("请求方法名：{}，请求参数：{}",joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "controllerLog()",returning = "returnObj")
    public void AfterReturning(JoinPoint joinPoint,Object returnObj){
        log.info("请求方法名：{}，返回结果：{}",joinPoint.getSignature().getName(),returnObj);
    }
}
