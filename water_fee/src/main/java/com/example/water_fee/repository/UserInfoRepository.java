package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findBySupplyNumber(String SupplyNumber);

    @Query(value = "SELECT count(*) from user_info ", nativeQuery = true)
    List<Object[]> findSumRegister();

    @Query(value = "SELECT sum(money_left) from user_info ", nativeQuery = true)
    List<Object[]> findSumMoneyLeft();

    @Query(value = "SELECT sum(water_left) from user_info ", nativeQuery = true)
    List<Object[]> findSumWaterLeft();
}
