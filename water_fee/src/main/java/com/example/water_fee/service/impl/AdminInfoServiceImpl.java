package com.example.water_fee.service.impl;

import com.example.water_fee.entity.AdminInfo;
import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.vo.AdminInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRechargeRepository userRechargeRepository;

    @Override
    public AdminInfoVO findAdminInfoVO() {
        AdminInfoVO adminInfoVO = new AdminInfoVO();
        AdminInfo adminInfo = adminInfoRepository.findAll().get(0);
        adminInfoVO.setUnitPrice(adminInfo.getUnitPrice());

        List<Integer[]> SumRegisterList = userInfoRepository.findSumRegister();
        for (Integer[] objs : SumRegisterList) {
            for (Integer obj : objs) {
                adminInfoVO.setSumRegister(obj);
            }
        }

        List<BigDecimal[]> MoneyLeftList = userInfoRepository.findSumMoneyLeft();
        for (BigDecimal[] objs : MoneyLeftList) {
            for (BigDecimal obj : objs) {
                adminInfoVO.setSumMoneyLeft(obj);
            }
        }

        List<BigDecimal[]> SumWaterLeftList = userInfoRepository.findSumWaterLeft();
        for (BigDecimal[] objs : SumWaterLeftList) {
            for (BigDecimal obj : objs) {
                adminInfoVO.setSumWaterLeft(obj);
            }
        }

        List<Integer[]> list = userRechargeRepository.findSumRecharge();
        for (Integer[] objs : list) {
            for (Integer obj : objs) {
                adminInfoVO.setSumRecharge(obj);
            }
        }

        return adminInfoVO;
    }
}
