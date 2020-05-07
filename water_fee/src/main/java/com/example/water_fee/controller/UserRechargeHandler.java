package com.example.water_fee.controller;

import com.example.water_fee.entity.UserInfo;
import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.service.UserRechargeService;
import com.example.water_fee.vo.UserRechargeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRecharge")
public class UserRechargeHandler {

    @Autowired
    private UserRechargeService userRechargeService;
    @Autowired
    private UserRechargeRepository userRechargeRepository;

    @GetMapping("/getRechargeFindAll/{page}/{size}")
    public Page<UserRecharge> finAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return userRechargeRepository.findAll(request);
    }

    @GetMapping("/getRecharge&{supplyNumber}/{page}/{size}")
    public Page<UserRecharge> findBySupplyNumberInfo(@PathVariable("supplyNumber") String supplyNumber, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return userRechargeRepository.findAll(request);
    }

    @GetMapping("/getRecharge&{supplyNumber}")
    public UserRechargeVO findBySupplyNumberRecharge(@PathVariable("supplyNumber") String supplyNumber){
        return userRechargeService.findSupplyNumberRecharge(supplyNumber);
    }
}
