package com.example.water_fee.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserInfoVO {
    private int status = 200;
    private String end = "查询成功";
    private String realName;
    private String supplyNumber;
    @JsonProperty("phoneNumber")
    private String userTel;
    @JsonProperty("address")
    private String userAddress;
    private BigDecimal moneyLeft;
    private BigDecimal waterLeft;
}
