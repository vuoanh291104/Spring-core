package com.example.springlearning.core;

import com.example.springlearning.core.config.AppConfig;
import com.example.springlearning.core.service.PhimService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreApplication {
    public static void main(String[] args) {
        // Khởi tạo Spring IoC Container sử dụng cấu hình Java (AppConfig.class)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy bean PhimService từ Spring Container
        PhimService phimService = context.getBean(PhimService.class);
        phimService.hienThiTenPhim();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
