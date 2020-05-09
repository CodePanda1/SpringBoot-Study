package com.example.water_fee.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdminInfoVO {
    private BigDecimal unitPrice;
    private Integer sumRegister;
    private Integer sumMoneyLeft;
    private Integer sumWaterLeft;
    private Integer sumRecharge;
}
