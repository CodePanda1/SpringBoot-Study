package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import com.example.water_fee.entity.UserStatistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserStatisticsRepositoryTest {

    @Autowired
    private UserStatisticsRepository repository;

    @Test
    void findAll(){
        List<UserStatistics> list= repository.findAll();
        System.out.println(list);
    }


}