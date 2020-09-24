package com.example.water_fee.service.impl;

import com.example.water_fee.entity.AdminInfo;
import com.example.water_fee.repository.AdminInfoRepository;
import com.example.water_fee.repository.UserInfoRepository;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.repository.UserStatisticsRepository;
import com.example.water_fee.service.AdminInfoService;
import com.example.water_fee.util.DateUtil;
import com.example.water_fee.vo.AdminInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRechargeRepository userRechargeRepository;
    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @Override
    public AdminInfoVO findAdminInfoVO() throws Exception {
        AdminInfoVO adminInfoVO = new AdminInfoVO();
        AdminInfo adminInfo = adminInfoRepository.findAll().get(0);
        adminInfoVO.setUnitPrice(adminInfo.getUnitPrice());

        List<Integer[]> SumRegisterList = userInfoRepository.findSumRegister();
        for (Integer[] objs : SumRegisterList) {
            for (Integer obj : objs) {
                adminInfoVO.setSumRegister(obj);
            }
        }

//        List<BigDecimal[]> MoneyLeftList = userInfoRepository.findSumMoneyLeft();
//        for (BigDecimal[] objs : MoneyLeftList) {
//            for (BigDecimal obj : objs) {
//                adminInfoVO.setSumMoneyLeft(obj);
//            }
//        }

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

        adminInfoVO.setXAxisDate(DateUtil.getMonthBetween());

        List<String> dateUtil = DateUtil.getMonthBetween();
        List<BigDecimal> seriesVO1dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO1dateList.add(userStatisticsRepository.CountStatisticsUser((String) time));
        }
        adminInfoVO.setSeriesDate1(seriesVO1dateList);

        List<BigDecimal> seriesVO2dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO2dateList.add(userRechargeRepository.SumRechargeAmount((String) time));
        }
        adminInfoVO.setSeriesDate2(seriesVO2dateList);

        List<BigDecimal> seriesVO3dateList = new ArrayList<>();
        for (Object time : dateUtil) {
            seriesVO3dateList.add(userStatisticsRepository.SumStatisticsAmount((String) time));
        }
        adminInfoVO.setSeriesDate3(seriesVO3dateList);

        return adminInfoVO;
    }
}
