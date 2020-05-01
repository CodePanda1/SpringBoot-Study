package com.example.water_fee.service;

import com.example.water_fee.vo.UserInfoVO;

public interface UserInfoService {
    public UserInfoVO findBySupplyNumber(String supplyNumber);
}
