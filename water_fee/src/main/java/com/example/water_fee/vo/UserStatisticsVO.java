package com.example.water_fee.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserStatisticsVO {
    private int status = 200;
    private String end = "查询成功";
    private List<StatisticsVO> statistics;
}
