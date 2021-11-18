package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@Builder
public class OrderDTO {

    @Positive
    private long id;

    @Positive
    private long productId;

    @Positive
    private long userId;

    @Positive
    private long userOrderId;

    private String number;
}
