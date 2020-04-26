package com.example.spring_phone_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor //带参构造
public class PhoneInfoVO {
    @JsonProperty("id")
    private Integer phoneId;
    @JsonProperty("title")
    private String phoneName;
    @JsonProperty("price")
    private String phonePrice;
    @JsonProperty("desc")
    private String phoneDescription;
    @JsonProperty("thumb")
    private String phoneIcon;
    private List<Map<String, String>> Tag;
}
