package com.example.water_fee.vo.adminechartvo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AdminChartVO {
        private TitleVO title;
        private TooltipVO tooltip;
        private LegendVO legend;
        private ToolboxVO toolbox;
        private boolean calculable = true;
        @JsonProperty("xAxis")
        private List<XAxisVO> xAxis;
        @JsonProperty("yAxis")
        private List<YAxisVO> yAxis;
        private List<SeriesVO> series;
}
