package com.example.water_fee.controller;

import com.example.water_fee.service.UserRechargeService;
import com.example.water_fee.vo.UserRechargeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRecharge")
public class UserRechargeHandler {

    @Autowired
    private UserRechargeService userRechargeService;

    @GetMapping("/getRecharge&{supplyNumber}")
    public UserRechargeVO findBySupplyNumberRecharge(@PathVariable("supplyNumber") String supplyNumber){
        return userRechargeService.findSupplyNumberRecharge(supplyNumber);
    }
}
