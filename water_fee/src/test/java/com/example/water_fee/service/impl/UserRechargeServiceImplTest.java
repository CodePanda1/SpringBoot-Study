package com.example.water_fee.service.impl;

import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.service.UserRechargeService;
import com.example.water_fee.vo.UserRechargeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@SpringBootTest
class UserRechargeServiceImplTest {

    @Autowired
    private UserRechargeRepository userRechargeRepository;
    @Autowired
    private UserRechargeService userRechargeService;

    @Test
    void findSupplyNumberRecharge() {
        UserRechargeVO userRechargeVO =userRechargeService.findSupplyNumberRecharge("FYCJ002");
        int i=0;
    }

    @Test
    public void findByBuyerOpenid(){
        PageRequest request = PageRequest.of(1, 3);

        Page<UserRecharge> result= userRechargeRepository.findBySupplyNumber("FYCJ001",request);
        for (UserRecharge userRecharge : result) {
            System.out.println(userRecharge);
        }

    }

}