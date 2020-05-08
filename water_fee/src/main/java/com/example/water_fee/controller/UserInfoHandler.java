package com.example.water_fee.controller;

import com.example.water_fee.entity.UserInfo;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.service.UserInfoService;
import com.example.water_fee.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userInfo")
public class UserInfoHandler {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/getInfoFindAll/{page}/{size}")
    public Page<UserInfo> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return userInfoRepository.findAll(request);
    }

    @GetMapping("/getInfo&{supplyNumber}")
    public UserInfoVO findBySupplyNumberInfo(@PathVariable("supplyNumber") String supplyNumber){
        return userInfoService.findBySupplyNumber(supplyNumber);
    }


}
