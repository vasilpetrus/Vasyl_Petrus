package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
public class UserOrderDTO {

    @Positive
    private long id;

    @NotEmpty(message = "Address should not be empty!")
    private String address;

    @NotEmpty(message = "Order date should not be empty!")
    private Date orderDate;

    @NotEmpty(message = "Delivery date should not be empty!")
    private Date deliveryDate;

    @NotEmpty(message = "Order status should not be empty!")
    private String status;
}
