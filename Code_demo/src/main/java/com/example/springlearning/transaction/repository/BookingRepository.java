package com.example.springlearning.transaction.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
    public void datVe(String tenNguoi) {
        System.out.println("Đặt vé cho: " + tenNguoi);
    }
}