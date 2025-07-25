package com.example.springlearning.transaction.service;

import com.example.springlearning.transaction.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void datNhieuVe(String... tenNguoi) {
        for (String ten : tenNguoi) {
            bookingRepository.datVe(ten);
            if (ten.equals("Lỗi")) {
                throw new RuntimeException("Lỗi khi đặt vé cho: " + ten);
            }
        }
    }
}
