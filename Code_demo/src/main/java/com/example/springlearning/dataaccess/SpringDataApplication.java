package com.example.springlearning.dataaccess;

import com.example.springlearning.dataaccess.entity.Phim;
import com.example.springlearning.dataaccess.repository.PhimJpaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Configuration // Đánh dấu đây là lớp cấu hình Spring
@ComponentScan("com.example.springlearning.dataaccess") // Quét các Spring Component trong gói này
@EnableJpaRepositories("com.example.springlearning.dataaccess.repository") // Kích hoạt Spring Data JPA repositories
public class SpringDataApplication {

    public static void main(String[] args) {
        // 1. Khởi tạo Spring IoC Container với lớp cấu hình này
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDataApplication.class);

        // 2. Lấy PhimJpaRepository bean từ Container
        PhimJpaRepository phimRepository = context.getBean(PhimJpaRepository.class);

        // 3. Thực hiện các thao tác với Repository
        System.out.println("--- Bắt đầu thao tác DB ---");

        // Lưu dữ liệu
        Phim phim1 = new Phim(null, "Ký ức kẻ sát nhân"); // ID sẽ được tự động tạo
        Phim phim2 = new Phim(null, "Parasite");
        Phim phim3 = new Phim(null, "Oldboy");

        phimRepository.save(phim1);
        phimRepository.save(phim2);
        phimRepository.save(phim3);
        System.out.println("Đã lưu 3 phim vào DB.");

        // Đọc tất cả dữ liệu
        System.out.println("\nDanh sách các phim trong DB:");
        List<Phim> allPhims = phimRepository.findAll();
        allPhims.forEach(phim -> System.out.println("ID: " + phim.getId() + ", Tên: " + phim.getTen()));

        // Tìm theo ID (ví dụ phim1)
        System.out.println("\nTìm phim có ID " + phim1.getId() + ":");
        phimRepository.findById(phim1.getId()).ifPresent(phim -> System.out.println("Tìm thấy: " + phim.getTen()));

        // Cập nhật (ví dụ phim1)
        phim1.setTen("Ký ức kẻ sát nhân (Bản đặc biệt)");
        phimRepository.save(phim1);
        System.out.println("\nĐã cập nhật phim có ID " + phim1.getId() + ": " + phimRepository.findById(phim1.getId()).get().getTen());

        // Xóa (ví dụ phim2)
        phimRepository.delete(phim2);
        System.out.println("\nĐã xóa phim có ID " + phim2.getId() + ".");
        System.out.println("Số lượng phim còn lại: " + phimRepository.count());

        System.out.println("--- Kết thúc thao tác DB ---");

        // Đóng context
        context.close();
    }
}