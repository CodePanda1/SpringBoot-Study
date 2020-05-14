package com.example.water_fee.vo.adminechartvo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FeatureVO {
    private MarkVO mark ;
    @JsonProperty("dataView")
    private DataViewVO dataView;
    @JsonProperty("magicType")
    private MagicTypeVO magicType;
    private RestoreVO restore;
    @JsonProperty("saveAsImage")
    private SaveAsImageVO saveAsImage;
}
