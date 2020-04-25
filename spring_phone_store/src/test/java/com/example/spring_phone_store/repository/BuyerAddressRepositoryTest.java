package com.example.spring_phone_store.repository;

import com.example.spring_phone_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll() {
        List<BuyerAddress> list = repository.findAll();
        for (BuyerAddress buyerAddress : list) {
            System.out.println(buyerAddress);
        }
    }

    @Test
    void save(){
        BuyerAddress buyerAddress=new BuyerAddress();
        buyerAddress.setAreaCode("12345");
        buyerAddress.setBuyerAddress("中国山东省济南市章丘区文博路2号");
        buyerAddress.setBuyerName("小红");
        buyerAddress.setBuyerPhone("13212122323");
        repository.save(buyerAddress);
    }

    @Test
    void update(){
        BuyerAddress buyerAddress=repository.findById(25).get();
        buyerAddress.setAreaCode("330104");
        repository.save(buyerAddress);
    }
}