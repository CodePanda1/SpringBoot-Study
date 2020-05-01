package com.example.water_fee.service.impl;

import com.example.water_fee.entity.UserStatistics;
import com.example.water_fee.repository.UserStatisticsRepository;
import com.example.water_fee.service.UserStatisticsService;
import com.example.water_fee.vo.StatisticsVO;
import com.example.water_fee.vo.UserStatisticsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @Override
    public UserStatisticsVO findBySupplyNumberStatistics(String supplyNumber) {
        List<UserStatistics> userStatisticsList = userStatisticsRepository.findBySupplyNumber(supplyNumber);
        List<StatisticsVO> statisticsVOList = new ArrayList<>();
        for (UserStatistics userStatistics : userStatisticsList) {
            StatisticsVO statisticsVO=new StatisticsVO();
            BeanUtils.copyProperties(userStatistics,statisticsVO);
            statisticsVOList.add(statisticsVO);
        }

        UserStatisticsVO userStatisticsVO = new UserStatisticsVO();
        userStatisticsVO.setStatistics(statisticsVOList);
        return userStatisticsVO;
    }
}
