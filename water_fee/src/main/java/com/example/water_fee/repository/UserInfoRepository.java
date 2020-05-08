package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    public List<UserInfo> findBySupplyNumber(String SupplyNumber);

    @Query(value = "SELECT money_left from user_info GROUP BY money_left ORDER BY sum(money_left) desc",
            nativeQuery = true)
    List<Object[]> findDomainAndCount();

}
