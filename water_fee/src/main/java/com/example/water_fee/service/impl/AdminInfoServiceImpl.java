package com.example.water_fee.service.impl;

import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.vo.AdminInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @Override
    public AdminInfoVO findAdminInfoVO() {
        return null;
    }
}
