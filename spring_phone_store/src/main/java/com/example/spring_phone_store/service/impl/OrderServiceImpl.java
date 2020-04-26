package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.dto.OrderDTO;
import com.example.spring_phone_store.entity.OrderMaster;
import com.example.spring_phone_store.entity.PhoneInfo;
import com.example.spring_phone_store.entity.PhoneSpecs;
import com.example.spring_phone_store.enums.PayStatusEnum;
import com.example.spring_phone_store.repository.OrderMasterRepository;
import com.example.spring_phone_store.repository.PhoneInfoRepository;
import com.example.spring_phone_store.repository.PhoneSpecsRepository;
import com.example.spring_phone_store.service.OrderService;
import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpaceId()).get();
        BeanUtils.copyProperties(phoneSpecs, orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        BeanUtils.copyProperties(phoneInfo, orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))//除100 转换为元
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))//乘购买数量
                .add(orderAmount);
        orderMaster.setOrderAmount(orderAmount);

        //生成唯一的orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus支付状态
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterRepository.save(orderMaster);

        //改库存
        phoneService.subStock(orderDTO.getSpaceId(),orderDTO.getPhoneQuantity());

        return orderDTO;
    }
}
