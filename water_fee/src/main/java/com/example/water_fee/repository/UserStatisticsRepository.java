package com.example.water_fee.repository;

import com.example.water_fee.entity.UserStatistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface UserStatisticsRepository extends JpaRepository<UserStatistics, String> {
    List<UserStatistics> findBySupplyNumber(String supplyNumber);

    Page<UserStatistics> findBySupplyNumber(String SupplyNumber, Pageable pageable);

    @Query(value = "select sum(statistics_daily) from user_statistics where convert(statistics_time,DATETIME) like ?%;",
            nativeQuery = true)
    BigDecimal SumStatisticsAmount(String statisticsTime);

    @Query(value = "select count(distinct supply_number) from user_statistics where convert(statistics_time,DATETIME) like ?%;",
            nativeQuery = true)
    BigDecimal CountStatisticsUser(String statisticsTime);
}
