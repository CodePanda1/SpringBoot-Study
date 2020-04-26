package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.dto.OrderDTO;
import com.example.spring_phone_store.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("王五");
        orderDTO.setBuyerPhone("15079799696");
        orderDTO.setBuyerAddress("北京市北京市东城区168号303室");
        orderDTO.setSpaceId(1);
        orderDTO.setPhoneQuantity(2);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }
}