package com.example.springlearning.core.config;

import com.example.springlearning.core.repository.PhimRepository;
import com.example.springlearning.core.service.PhimService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring inject PhimRepository vào PhimService

@Configuration //Annotation này đánh dấu lớp AppConfig là một lớp cấu hình Spring.Spring IoC Container sẽ quét lớp này để tìm các định nghĩa bean
public class AppConfig {

    // Khai báo một Bean cho PhimRepository
    @Bean
    public PhimRepository phimRepository() {
        return new PhimRepository();
    }

    // Khai báo một Bean cho PhimService, DI bằng constructor
    @Bean
    public PhimService phimService() {
        return new PhimService(phimRepository());
    }
}
