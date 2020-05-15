package com.example.water_fee.controller;

import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.vo.AdminInfoVO;
import com.example.water_fee.vo.adminechartvo.AdminChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adminInfo")
public class AdminInfoHandler {

    @Autowired
    private AdminInfoService adminInfoService;
    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @GetMapping("adminInfoFindAll")
    public AdminInfoVO adminInfoFindAll() {
        return adminInfoService.findAdminInfoVO();
    }

    @GetMapping("getFindAdminChartVO")
    public AdminChartVO findAdminChartVO() throws Exception {
        return adminInfoService.findAdminChartVO();
    }
}
