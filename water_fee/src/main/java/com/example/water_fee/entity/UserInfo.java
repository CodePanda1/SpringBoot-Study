package com.example.water_fee.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String supplyNumber;
    private String realName;
    private String userTel;
    private String userAddress;
    private BigDecimal moneyLeft;
    private BigDecimal waterLeft;
    private Date createTime;
    private Date updateTime;
}
