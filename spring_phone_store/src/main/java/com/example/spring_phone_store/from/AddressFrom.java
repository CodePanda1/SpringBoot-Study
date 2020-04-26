package com.example.spring_phone_store.from;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressFrom {
    private Integer id;
    @NotEmpty(message = "姓名不能为空") //不能为空  非空验证
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "省不能为空")
    private String province;
    @NotEmpty(message = "市不能为空")
    private String city;
    @NotEmpty(message = "区不能为空")
    private String county;
    @NotEmpty(message = "编码不能为空")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
