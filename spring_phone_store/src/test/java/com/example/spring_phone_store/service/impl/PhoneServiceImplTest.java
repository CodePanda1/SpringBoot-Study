package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void findDataVO() {
        DataVO dataVO=phoneService.findDataVO();
        int i=0;
    }
}