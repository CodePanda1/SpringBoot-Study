package com.example.spring_phone_store.controller;

import com.example.spring_phone_store.dto.OrderDTO;
import com.example.spring_phone_store.exception.PhoneException;
import com.example.spring_phone_store.from.OrderFrom;
import com.example.spring_phone_store.service.OrderService;
import com.example.spring_phone_store.util.ResultVOUtil;
import com.example.spring_phone_store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderFrom orderFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数错误,orderFrom{}", orderFrom);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerPhone(orderFrom.getTel());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setSpaceId(orderFrom.getSpecsId());
        orderDTO.setPhoneQuantity(orderFrom.getQuantity());

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO findOrderDetail(@PathVariable("orderId") String orderId) {
        return ResultVOUtil.success(orderService.findOrderDerDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO pay(@PathVariable("orderId") String orderId) {
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderService.pay(orderId));
        return ResultVOUtil.success(map);
    }
}
