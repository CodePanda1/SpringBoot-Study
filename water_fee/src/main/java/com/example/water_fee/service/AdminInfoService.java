package com.example.water_fee.service;

import com.example.water_fee.vo.AdminInfoVO;
import com.example.water_fee.vo.adminechartvo.AdminChartVO;

public interface AdminInfoService {
    public AdminInfoVO findAdminInfoVO();

    public AdminChartVO findAdminChartVO();
}
