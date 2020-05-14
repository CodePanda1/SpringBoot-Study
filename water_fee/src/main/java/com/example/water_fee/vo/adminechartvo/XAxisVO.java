package com.example.water_fee.vo.adminechartvo;

import lombok.Data;

import java.util.List;

@Data
public class XAxisVO {
    private String type = "category";
    private boolean boundaryGap = false;
    private List<String> data;
}
