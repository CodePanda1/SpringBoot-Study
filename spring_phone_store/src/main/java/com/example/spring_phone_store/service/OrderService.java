package com.example.spring_phone_store.service;

import com.example.spring_phone_store.dto.OrderDTO;
import com.example.spring_phone_store.vo.OrderDetailVO;

public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);

    public OrderDetailVO findOrderDerDetailByOrderId(String orderId);

    public String pay(String orderId);
}
