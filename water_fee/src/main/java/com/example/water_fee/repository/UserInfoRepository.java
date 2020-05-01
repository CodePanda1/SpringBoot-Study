package com.example.water_fee.repository;

import com.example.water_fee.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public List<UserInfo> findBySupplyNumber(String SupplyNumber);
}
