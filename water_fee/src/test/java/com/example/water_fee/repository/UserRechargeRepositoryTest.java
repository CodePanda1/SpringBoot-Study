package com.example.water_fee.repository;

import com.example.water_fee.entity.UserRecharge;
import com.example.water_fee.util.KeyUtil;
import com.example.water_fee.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        userRecharge.setSupplyNumber("FYCJ003");
        userRecharge.setRechargeStatus(1);
        userRecharge.setRechargeAmount(new BigDecimal(8.12));
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

    @Test
    void dateSumRechargeAmount() throws Exception {
        List object = DateUtil.getMonthBetween();
        System.out.println(object);
        ArrayList arrayList = new ArrayList();
        for (Object o : object) {
//            BigDecimal sumRechargeAmount = repository.SumRechargeAmount((String) o);
            arrayList.add(repository.SumRechargeAmount((String) o));
        }
        System.out.println(arrayList);
//        BigDecimal sumRechargeAmount = repository.SumRechargeAmount("2020-04");
//        System.out.println(sumRechargeAmount);
    }

}