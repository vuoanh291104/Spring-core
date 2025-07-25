package com.example.springlearning.dataaccess.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Đánh dấu đây là một JPA Entity, ánh xạ với một bảng trong DB
@Data // Lombok: Tự động tạo getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: Tự động tạo constructor không đối số
@AllArgsConstructor // Lombok: Tự động tạo constructor với tất cả các đối số
public class Phim {
    @Id // Đánh dấu trường này là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Long id;
    private String ten;

    public Phim(Object o, String kýỨcKẻSátNhân) {
    }

    public Long getId() {
    }

    public String getTen() {
    }

    public void setTen(String s) {
    }

    // Constructor thủ công nếu không dùng Lombok @AllArgsConstructor
    // public Phim(String ten) {
    //     this.ten = ten;
    // }
}