package com.example.water_fee.controller;

import com.example.water_fee.service.UserInfoService;
import com.example.water_fee.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userInfo")
public class UserInfoHandler {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getInfo&{supplyNumber}")
    public UserInfoVO findBySupplyNumberInfo(@PathVariable("supplyNumber") String supplyNumber){
        return userInfoService.findBySupplyNumber(supplyNumber);
    }
}
