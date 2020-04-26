package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.from.AddressFrom;
import com.example.spring_phone_store.service.AddressService;
import com.example.spring_phone_store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        int i = 0;
    }

    @Test
    void SaveOrUpdate() {
        AddressFrom addressFrom = new AddressFrom();
        addressFrom.setId(26);
        addressFrom.setName("王五");
        addressFrom.setTel("17899999999");
        addressFrom.setProvince("北京市");
        addressFrom.setCity("北京市");
        addressFrom.setCounty("东城区");
        addressFrom.setAreaCode("110101");
        addressFrom.setAddressDetail("168号303室");
        addressService.saveOrUpdate(addressFrom);
    }
}