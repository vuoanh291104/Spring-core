package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Demo với XML Config
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        MessageService xmlService = xmlContext.getBean("messageService", MessageService.class);
        System.out.println("[XML] " + xmlService.getMessage());

        // Demo với Java Config + @ComponentScan
        AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService javaService = javaContext.getBean(MessageService.class);
        System.out.println("[Java Config] " + javaService.getMessage());

        javaContext.close();
        ((ClassPathXmlApplicationContext) xmlContext).close();
    }
}
