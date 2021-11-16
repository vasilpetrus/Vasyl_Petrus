package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserOrderDTO {

    private long id;
    private String address;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
}
