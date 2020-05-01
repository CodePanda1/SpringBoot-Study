package com.example.water_fee.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class StatisticsVO {
    private String statisticsId;
    private String supplyNumber;
    private BigDecimal statisticsDaily;
    private Date statisticsTime;
}
