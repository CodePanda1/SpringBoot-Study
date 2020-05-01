package com.example.water_fee.controller;


import com.example.water_fee.service.UserStatisticsService;
import com.example.water_fee.vo.UserStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userStatistics")
public class UserStatisticsHandler {

    @Autowired
    private UserStatisticsService userStatisticsService;

    @GetMapping("/getStatistics&{supplyNumber}")
    public UserStatisticsVO findBySupplyNumberStatistics(@PathVariable("supplyNumber")String supplyNumber){
        return userStatisticsService.findBySupplyNumberStatistics(supplyNumber);
    }
}
