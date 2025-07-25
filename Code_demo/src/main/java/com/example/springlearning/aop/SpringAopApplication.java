package com.example.springlearning.aop;

import com.example.springlearning.aop.service.AopDemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //Đánh dấu lớp này là lớp cấu hình Spring
@ComponentScan("com.example.springlearning.aop")
@EnableAspectJAutoProxy // Kích hoạt khả năng xử lý AspectJ-style aspects trong Spring
public class SpringAopApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringAopApplication.class);  //Khởi tạo Spring IoC Container với lớp cấu hình
        AopDemoService service = context.getBean(AopDemoService.class);  //Lấy bean AopDemoService từ Container
        service.thucHienGiaoDich();
        context.close();
    }
}
