package com.example.springlearning.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AopDemoService {
    public void thucHienGiaoDich() {

        System.out.println("Đang thực hiện logic nghiệp vụ chính...");
    }
}