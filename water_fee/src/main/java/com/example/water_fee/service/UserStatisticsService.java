package com.example.water_fee.service;

import com.example.water_fee.vo.UserStatisticsVO;

import java.util.List;

public interface UserStatisticsService  {
    public UserStatisticsVO findBySupplyNumberStatistics(String supplyNumber);
}
