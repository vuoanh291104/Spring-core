package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Hello from EmailMessageService!";
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailMessageService initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailMessageService destroyed.");
    }
}

