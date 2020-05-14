package com.example.water_fee.vo.adminechartvo;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class MagicTypeVO {
    private boolean show = true;
    private List<String> type = Arrays.asList(new String[]{"line", "bar", "stack", "tiled"});
}
