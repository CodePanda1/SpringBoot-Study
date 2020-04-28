package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    void findAll(){
        List<UserInfo> list= repository.findAll();
        System.out.println(list);
    }

    @Test
    void update(){
        UserInfo userInfo=repository.findById(1).get();
        userInfo.setRealName("330104");
        repository.save(userInfo);
    }
}