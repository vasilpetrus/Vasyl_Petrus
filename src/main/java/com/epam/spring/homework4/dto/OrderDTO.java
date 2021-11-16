package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private long id;
    private long productId;
    private long userId;
    private long userOrderId;
    private String number;
}
