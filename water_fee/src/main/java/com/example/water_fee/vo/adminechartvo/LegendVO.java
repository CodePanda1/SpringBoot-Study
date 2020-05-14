package com.example.water_fee.vo.adminechartvo;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class LegendVO {
    private List<String> data = Arrays.asList(new String[]{"活跃用户", "用户金额", "月用水量"});
}
