package com.dev.dataviewspring.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("v_channelno")
public class VChannelnoEntity {
    private String channelname;
    private Integer num;
}
