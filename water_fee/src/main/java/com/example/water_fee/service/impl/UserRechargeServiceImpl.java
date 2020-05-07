package com.example.water_fee.service.impl;

import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.repository.UserRechargeRepository;
import com.example.water_fee.service.UserRechargeService;
import com.example.water_fee.vo.RechargeVO;
import com.example.water_fee.vo.UserRechargeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRechargeServiceImpl implements UserRechargeService {

    @Autowired
    private UserRechargeRepository userRechargeRepository;

    @Override
    public UserRechargeVO findSupplyNumberRecharge(String supplyNumber) {
        List<UserRecharge> userRechargeList = userRechargeRepository.findBySupplyNumber(supplyNumber);
        List<RechargeVO> rechargeVOList = new ArrayList<>();
        for (UserRecharge userRecharge : userRechargeList) {
            RechargeVO rechargeVO =new RechargeVO();
            BeanUtils.copyProperties(userRecharge, rechargeVO);
            rechargeVOList.add(rechargeVO);
        }
        UserRechargeVO userRechargeVO=new UserRechargeVO();
        userRechargeVO.setRecharge(rechargeVOList);
        return userRechargeVO;
    }

}
