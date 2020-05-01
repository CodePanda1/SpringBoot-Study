package com.example.water_fee.service.impl;

import com.example.water_fee.service.UserRechargeService;
import com.example.water_fee.vo.UserRechargeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRechargeServiceImplTest {

    @Autowired
    private UserRechargeService userRechargeService;

    @Test
    void findSupplyNumberRecharge() {
        UserRechargeVO userRechargeVO =userRechargeService.findSupplyNumberRecharge("FYCJ002");
        int i=0;
    }
}