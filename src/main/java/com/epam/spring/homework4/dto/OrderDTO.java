package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.entity.UserOrder;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    @Positive
    private long id;

    private List<Product> product;

    private  UserDTO user;

    private UserOrderDTO userOrder;

    private String number;
}
