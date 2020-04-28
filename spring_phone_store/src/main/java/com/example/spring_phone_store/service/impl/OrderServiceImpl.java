package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.dto.OrderDTO;
import com.example.spring_phone_store.entity.OrderMaster;
import com.example.spring_phone_store.entity.PhoneInfo;
import com.example.spring_phone_store.entity.PhoneSpecs;
import com.example.spring_phone_store.enums.PayStatusEnum;
import com.example.spring_phone_store.enums.ResultEnum;
import com.example.spring_phone_store.exception.PhoneException;
import com.example.spring_phone_store.repository.OrderMasterRepository;
import com.example.spring_phone_store.repository.PhoneInfoRepository;
import com.example.spring_phone_store.repository.PhoneSpecsRepository;
import com.example.spring_phone_store.service.OrderService;
import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.util.KeyUtil;
import com.example.spring_phone_store.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
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
        if (phoneSpecs == null) {
            log.error("【创建订单】规格不存在，phoneSpecs{}", phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs, orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if (phoneInfo == null) {
            log.error("【创建订单】手机不存在，phoneInfo{}", phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo, orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))//除100 转换为元
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))//乘购买数量
                .add(orderAmount)
                .add(new BigDecimal(10));//加运费
        orderMaster.setOrderAmount(orderAmount);

        //生成唯一的orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus支付状态
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterRepository.save(orderMaster);

        //改库存
        phoneService.subStock(orderDTO.getSpaceId(), orderDTO.getPhoneQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDerDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            log.error("【查询订单】订单不存在，orderMaster{}", orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        BeanUtils.copyProperties(orderMaster, orderDetailVO);
        //数值类型转String 分转元
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100)).toString());

        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            log.error("【支付订单】订单不存在，orderMaster{}", orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        if (orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())) {
            orderMaster.setPayStatus(PayStatusEnum.PIAD.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付，orderMaster{}", orderMaster);
        }

        return orderId;
    }
}
