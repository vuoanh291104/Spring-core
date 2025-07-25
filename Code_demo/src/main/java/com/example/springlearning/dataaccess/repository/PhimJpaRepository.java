package com.example.springlearning.dataaccess.repository;

import com.example.springlearning.dataaccess.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Đánh dấu đây là một Spring Repository component
public interface PhimJpaRepository extends JpaRepository<Phim, Long> {
    // Spring Data JPA sẽ tự động tạo các phương thức CRUD
}