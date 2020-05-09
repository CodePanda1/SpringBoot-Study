package com.example.water_fee.controller;

import com.example.water_fee.entity.AdminInfo;
import com.example.water_fee.repository.AdminInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoHandler {

    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @GetMapping("adminInfoFindAll")
    public List<AdminInfo> adminInfoFindAll(){
        return adminInfoRepository.findAll();
    }
}
