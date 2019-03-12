package com.pulzel.utils;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {
    @Around("execution(* com.pulzel.controller.*.*(..)) && args(T)")
    public void log(String T){
        System.out.println(T+" Log printed before method");
    }
}

