package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.vo.DataVO;
import com.example.spring_phone_store.vo.PhoneInfoVO;
import com.example.spring_phone_store.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void findDataVO() {
        DataVO dataVO = phoneService.findDataVO();
        int i = 0;
    }

    @Test
    void findPhoneInfoVObyCategoryType() {
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(2);
        int i = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVO specsPackageVO=phoneService.findSpecsByPhoneId(1);
        int i=1;
    }

    @Test
    void subStock(){
        phoneService.subStock(1,3);
    }
}