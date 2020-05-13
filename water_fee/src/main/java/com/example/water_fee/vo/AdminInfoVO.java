package com.example.water_fee.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdminInfoVO {
    private int status = 200;
    private String end = "查询成功";
    private BigDecimal unitPrice;
    private Integer sumRegister;
    private BigDecimal sumMoneyLeft;
    private BigDecimal sumWaterLeft;
    private Integer sumRecharge;
}
