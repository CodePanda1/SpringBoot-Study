package com.example.water_fee.service.impl;

import com.example.water_fee.entity.UserInfo;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.service.UserInfoService;
import com.example.water_fee.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoVO findBySupplyNumber(String supplyNumber) {
        List<UserInfo> userInfoList = userInfoRepository.findBySupplyNumber(supplyNumber);
        List<UserInfoVO> userInfoVOList = new ArrayList<>();
        UserInfoVO userInfoVO = new UserInfoVO();
        for (UserInfo userInfo : userInfoList) {
            BeanUtils.copyProperties(userInfo, userInfoVO);
            userInfoVOList.add(userInfoVO);
        }
        return userInfoVO;
    }
}
