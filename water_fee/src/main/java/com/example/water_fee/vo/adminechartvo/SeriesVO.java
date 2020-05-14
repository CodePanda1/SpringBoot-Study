package com.example.water_fee.vo.adminechartvo;

import lombok.Data;

import java.util.List;

@Data
public class SeriesVO {
    private String name;
    private String type;
    private String color;
    private boolean smooth;
    private ItemStyleVO itemStyle;
    private List<Integer> data;
}
