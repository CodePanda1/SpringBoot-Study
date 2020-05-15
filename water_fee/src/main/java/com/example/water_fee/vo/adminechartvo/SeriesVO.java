package com.example.water_fee.vo.adminechartvo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SeriesVO {
    private String name;
    private String type = "line";
    private String color = "#1890FF";
    private boolean smooth = true;
    private ItemStyleVO itemStyle;
    private List<BigDecimal> data;
}
