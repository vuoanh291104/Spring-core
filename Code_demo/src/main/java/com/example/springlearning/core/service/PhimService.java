package com.example.springlearning.core.service;

import com.example.springlearning.core.repository.PhimRepository;

public class PhimService {

    private final PhimRepository phimRepository;

    // DI bằng constructor
    public PhimService(PhimRepository phimRepository) {
        this.phimRepository = phimRepository;
    }
    //PhimService sẽ sử dụng PhimRepository để lấy tên phim và sau đó hiển thị nó ra console
    public void hienThiTenPhim() {
        System.out.println("Tên phim là: " + phimRepository.getTenPhim());
    }
}
