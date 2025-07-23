package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
    @Before("execution(* org.example.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* org.example.service.*.*(..))", returning = "result")
    public void afterMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After: " + joinPoint.getSignature().getName());
    }
}
