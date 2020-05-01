package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    void findAll() {
        List<UserInfo> list = repository.findAll();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    @Test
    void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setSupplyNumber("FYCJ002");
        userInfo.setRealName("李小红");
        userInfo.setUserTel("13896963232");
        userInfo.setUserAddress("中国山东省济南市章丘区文博路2号");
        userInfo.setMoneyLeft(new BigDecimal(36.021));
        userInfo.setWaterLeft(new BigDecimal(965.02112));
        repository.save(userInfo);
    }

    @Test
    void update() {
        List<UserInfo> userInfoList = repository.findBySupplyNumber("FYCJ002");
        for (UserInfo userInfo : userInfoList) {
            userInfo.setRealName("111");
            repository.save(userInfo);
        }
    }
}