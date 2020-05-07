package com.example.water_fee.repository;

import com.example.water_fee.entity.UserStatistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStatisticsRepository extends JpaRepository<UserStatistics, String> {
    public List<UserStatistics> findBySupplyNumber(String supplyNumber);

    Page<UserStatistics> findBySupplyNumber(String SupplyNumber, Pageable pageable);
}
