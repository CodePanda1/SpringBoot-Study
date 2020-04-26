package com.example.spring_phone_store.exception;

import com.example.spring_phone_store.enums.ResultEnum;

public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
