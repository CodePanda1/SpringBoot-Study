package com.example.water_fee.service.impl;

import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.vo.AdminInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminInfoServiceImplTest {

    @Autowired
    private AdminInfoService adminInfoService;

    @Test
    void findAdminInfoVO() {
        AdminInfoVO adminInfoVO =adminInfoService.findAdminInfoVO();
        System.out.println(adminInfoVO);
    }
}