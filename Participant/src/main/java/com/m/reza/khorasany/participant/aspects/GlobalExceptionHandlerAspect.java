package com.m.reza.khorasany.participant.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class GlobalExceptionHandlerAspect {

    @Around("within(hu.ak_akademia_spring_data_jpa_crud.controller.exception.GlobalExceptionHandler)")
    public Object logGlobalException(final ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();
        final Throwable throwable = (Throwable) args[0];
        log.error("Handled exception:", throwable);
        return joinPoint.proceed();
    }
}
