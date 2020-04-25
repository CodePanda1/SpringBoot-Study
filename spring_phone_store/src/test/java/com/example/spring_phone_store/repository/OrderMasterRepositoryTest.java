package com.example.spring_phone_store.repository;

import com.example.spring_phone_store.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findAll() {
        List<OrderMaster> list = repository.findAll();
        for (OrderMaster orderMaster : list) {
            System.out.println(orderMaster);
        }
    }

    @Test
    void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12312321321");
        orderMaster.setBuyerAddress("山东省济南市章丘区文博路二号");
        orderMaster.setBuyerName("华强");
        orderMaster.setBuyerPhone("13290908080");
        orderMaster.setPhoneIcon("../static/901283478953279823");
        orderMaster.setPhoneName("iPhone XS Max");
        orderMaster.setPhoneQuantity(2);
        orderMaster.setPhoneId(1);
        orderMaster.setOrderAmount(new BigDecimal(16000));
        orderMaster.setPayStatus(1);
        orderMaster.setSpecsId(1);
        orderMaster.setSpecsPrice(new BigDecimal(800000));
        orderMaster.setSpecsName("64GB");
        repository.save(orderMaster);
    }

    @Test
    void findById() {
        OrderMaster orderMaster = repository.findById("12312321321").get();
        System.out.println(orderMaster);
    }

    @Test
    void pay(){
        OrderMaster orderMaster=repository.findById("12312321321").get();
        orderMaster.setPayStatus(1);
        repository.save(orderMaster);
    }
}