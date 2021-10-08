package com.dev.dataviewspring.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("v_user_login")
public class VUserLoginEntity {
    private String imei;
    private Integer logTimes;
    private String firstLoginTime;
    private Integer onlineTime;
}
