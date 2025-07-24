package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.example.service.UserService.createUser(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP-Before] Method called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* org.example.service.UserService.deleteUser(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("[AOP-AfterReturning] Method completed: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* org.example.service.UserService.updateUser(..))")
    public void logAfterThrowing(JoinPoint joinPoint) {
        System.out.println("[AOP-AfterThrowing] Exception thrown in method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* org.example.service.UserService.*(..))")
    public void logAfterFinally(JoinPoint joinPoint) {
        System.out.println("[AOP-After (Finally)] Method finished: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* org.example.service.UserService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[AOP-Around] Start method: " + joinPoint.getSignature().getName());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("[AOP-Around] Exception in method: " + e.getMessage());
            throw e;
        }
        System.out.println("[AOP-Around] End method: " + joinPoint.getSignature().getName());
        return result;
    }
}
