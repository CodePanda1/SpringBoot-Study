package com.example.water_fee.repository;

import com.example.water_fee.entity.UserStatistics;
import com.example.water_fee.util.KeyUtil;
import com.example.water_fee.vo.UserStatisticsVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class UserStatisticsRepositoryTest {

    @Autowired
    private UserStatisticsRepository repository;

    @Test
    void findAll() {
        List<UserStatistics> list = repository.findAll();
        System.out.println(list);
    }

    @Test
    void statistics() {
        UserStatistics userStatistics = new UserStatistics();
        userStatistics.setStatisticsId(KeyUtil.createUniqueKey());
        userStatistics.setStatisticsDaily(new BigDecimal(2.923));
        userStatistics.setSupplyNumber("FYCJ001");
        repository.save(userStatistics);
    }


}