package com.example.water_fee.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class UserStatistics {
    @Id
    private String statisticsId;
    private String supplyNumber;
    private BigDecimal statisticsDaily;
    private Date statisticsTime;
}
