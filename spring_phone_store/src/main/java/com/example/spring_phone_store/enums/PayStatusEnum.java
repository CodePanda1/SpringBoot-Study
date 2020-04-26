package com.example.spring_phone_store.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    UNPIAD(0,"未支付"),
    PIAD(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
