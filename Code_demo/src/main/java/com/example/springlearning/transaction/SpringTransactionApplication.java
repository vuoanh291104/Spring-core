package com.example.springlearning.transaction;

import com.example.springlearning.transaction.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.springlearning.transaction")
public class SpringTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BookingService service) {
        return args -> {
            try {
                service.datNhieuVe("An", "Binh", "Lỗi", "Cuong");
            } catch (Exception e) {
                System.out.println("Giao dịch bị rollback: " + e.getMessage());
            }
        };
    }
}
