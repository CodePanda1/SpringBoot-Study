package com.example.water_fee.controller;


import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.entity.UserStatistics;
import com.example.water_fee.repository.UserStatisticsRepository;
import com.example.water_fee.service.UserStatisticsService;
import com.example.water_fee.vo.UserStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userStatistics")
public class UserStatisticsHandler {

    @Autowired
    private UserStatisticsService userStatisticsService;
    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @GetMapping("/getStatisticsFindAll/{page}/{size}")
    public Page<UserStatistics> finAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return userStatisticsRepository.findAll(request);
    }

    @GetMapping("/getStatistics&{supplyNumber}")
    public UserStatisticsVO findBySupplyNumberStatistics(@PathVariable("supplyNumber")String supplyNumber){
        return userStatisticsService.findBySupplyNumberStatistics(supplyNumber);
    }

    @GetMapping("/getStatistics&{supplyNumber}/{page}/{size}")
    public Page<UserStatistics> findBySupplyNumberStatisticsPage(
            @PathVariable("supplyNumber") String supplyNumber,
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return userStatisticsRepository.findBySupplyNumber(supplyNumber,request);
    }
}
