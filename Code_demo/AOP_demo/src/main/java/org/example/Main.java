package org.example;

import org.example.config.AppConfig;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.createUser("Sakura");
        userService.deleteUser("Shizuka");
        try {
            userService.updateUser("Yamada");
        } catch (Exception ignored) {}

        context.close();
    }
}