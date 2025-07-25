package com.example.springlearning.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //Annotation này biến một lớp Java thông thường thành một aspect trong Spring AOP.
@Component  //thêm @Component để @ComponentScan có thể tìm thấy và đăng ký LoggingAspect vào Spring Container.
public class LoggingAspect {

    @Before("execution(* com.example.springlearning.aop.service.AopDemoService.thucHienGiaoDich(..))")
    public void logBefore() {
        System.out.println("[AOP] Bắt đầu giao dịch...");
    }

    @After("execution(* com.example.springlearning.aop.service.AopDemoService.thucHienGiaoDich(..))")
    public void logAfter() {
        System.out.println("[AOP] Kết thúc giao dịch.");
    }
}
