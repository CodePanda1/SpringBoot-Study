package com.example.water_fee.repository;

import com.example.water_fee.entity.UserRecharge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRechargeRepository extends JpaRepository<UserRecharge, String> {
    List<UserRecharge> findBySupplyNumber(String SupplyNumber);

    Page<UserRecharge> findBySupplyNumber(String SupplyNumber, Pageable pageable);

    @Query(value = "SELECT count(*) from user_recharge where recharge_status = 1", nativeQuery = true)
    List<Object[]> findSumRecharge();
}