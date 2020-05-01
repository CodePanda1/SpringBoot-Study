package com.example.water_fee.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminInfoRepositoryTest {

    @Autowired
    private AdminInfoRepository repository;

    @Test
    void findAll(){
        System.out.println(repository.findAll());
    }

}