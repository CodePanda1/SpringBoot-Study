package com.example.spring_phone_store.service;

import com.example.spring_phone_store.dto.OrderDTO;
import org.springframework.stereotype.Service;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
}
