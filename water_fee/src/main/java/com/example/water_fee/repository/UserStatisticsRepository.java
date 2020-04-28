package com.example.water_fee.repository;

import com.example.water_fee.entity.UserStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatisticsRepository extends JpaRepository<UserStatistics,String> {
}
