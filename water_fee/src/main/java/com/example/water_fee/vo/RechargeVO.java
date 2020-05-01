package com.example.water_fee.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class RechargeVO {
    @JsonProperty("openId")
    private String rechargeId;
    private String supplyNumber;
    @JsonProperty("money")
    private BigDecimal rechargeAmount;
    @JsonProperty("payTime")
    private Date rechargeTime;
}
