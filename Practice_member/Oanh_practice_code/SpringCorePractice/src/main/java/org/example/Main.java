package org.example;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        DataSource ds = context.getBean(DataSource.class);
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             InputStream in = Main.class.getClassLoader().getResourceAsStream("schema.sql")) {
            String sql = new String(in.readAllBytes());
            stmt.execute(sql);
        }

        UserService userService = context.getBean(UserService.class);
        userService.addUser(new User(1, "Oanh"));
        userService.addUser(new User(2, "Thanh"));

        userService.getAllUsers().forEach(System.out::println);

        context.close();
    }
}
