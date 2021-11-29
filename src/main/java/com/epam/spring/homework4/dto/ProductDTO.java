package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
public class ProductDTO {

    @Positive
    private long id;

    private CategoryDTO category;

    @NotEmpty(message = "Product name should not be empty!")
    private String name;

    private String description;

    @Positive
    private Double price;

    @NotEmpty(message = "Product status should not be empty!")
    private String status;

    private String photo;

    private long orderNumber;
}
