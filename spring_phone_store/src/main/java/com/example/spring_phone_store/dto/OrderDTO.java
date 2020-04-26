package com.example.spring_phone_store.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer spaceId;
    private Integer phoneQuantity;
}
