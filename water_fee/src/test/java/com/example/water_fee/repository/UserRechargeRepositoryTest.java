package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import com.example.water_fee.entity.UserRecharge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRechargeRepositoryTest {

    @Autowired
    private UserRechargeRepository repository;

    @Test
    void findAll(){
        List<UserRecharge> list= repository.findAll();
        System.out.println(list);
    }

}