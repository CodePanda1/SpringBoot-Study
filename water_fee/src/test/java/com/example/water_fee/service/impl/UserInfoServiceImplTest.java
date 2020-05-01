package com.example.water_fee.service.impl;

import com.example.water_fee.service.UserInfoService;
import com.example.water_fee.vo.UserInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void findBySupplyNumber() {
        UserInfoVO userInfoVO = userInfoService.findBySupplyNumber("FYCJ001");
        int i = 0;
    }
}