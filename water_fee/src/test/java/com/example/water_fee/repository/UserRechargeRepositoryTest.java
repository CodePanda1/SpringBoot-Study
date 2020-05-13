package com.example.water_fee.repository;

import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.util.KeyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class UserRechargeRepositoryTest {

    @Autowired
    private UserRechargeRepository repository;

    @Test
    void findAll() {
        List<UserRecharge> list = repository.findAll();
        for (UserRecharge userRecharge : list) {
            System.out.println(userRecharge);
        }
    }

    @Test
    void findSupplyNumberRecharge() {
        List<UserRecharge> userRechargeList = repository.findBySupplyNumber("FYCJ002");
        for (UserRecharge userRecharge : userRechargeList) {
            System.out.println(userRecharge);
        }
    }

    @Test
    void recharge() {
        UserRecharge userRecharge = new UserRecharge();
        userRecharge.setRechargeId(KeyUtil.createUniqueKey());
        userRecharge.setSupplyNumber("FYCJ001");
        userRecharge.setRechargeAmount(new BigDecimal(89.12));
        repository.save(userRecharge);
    }

    @Test
    void sumRecharge() {
        List<Integer[]> list = repository.findSumRecharge();
        for (Object[] objs : list) {
            for (int i = 0; i < objs.length; i++) {
                System.out.print(objs[i]);
            }
        }
    }

    @Test
    void qqqRecharge() {
        List<Integer[]> list = repository.SumRecharge();
        for (Integer[] objs : list) {
            for (int i = 0; i < objs.length; i++) {
                System.out.print(objs[i]);
            }
        }
    }

}