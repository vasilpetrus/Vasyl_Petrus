package com.epam.spring.homework4.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private long id;
    private long productId;
    private long userId;
    private long userOrderId;
    private String number;
}
