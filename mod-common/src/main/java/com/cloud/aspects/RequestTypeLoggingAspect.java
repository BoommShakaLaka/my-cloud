package com.cloud.aspects;

import com.cloud.annotations.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class RequestTypeLoggingAspect {


    @Pointcut("@annotation(com.cloud.annotations.RequestType)")
    private void point() {

    }

    @Around("point()&&@annotation(requestType)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, RequestType requestType) throws Throwable {
        proceedingJoinPoint.getArgs();
        log.info("args[0]:{}", proceedingJoinPoint.getArgs()[0].toString());
        log.info("RequestType.value: {},RequestType.type: {}", requestType.value(),requestType.type());

        return proceedingJoinPoint.proceed();
    }
}
