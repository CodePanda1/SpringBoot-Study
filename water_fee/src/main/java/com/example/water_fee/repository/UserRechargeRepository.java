package com.example.water_fee.repository;

import com.example.water_fee.entity.UserRecharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRechargeRepository extends JpaRepository<UserRecharge, String> {
    public List<UserRecharge> findBySupplyNumber(String SupplyNumber);
}