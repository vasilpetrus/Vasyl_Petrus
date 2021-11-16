package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private long id;
    private long categoryId;
    private String name;
    private String description;
    private Double price;
    private String status;
    private String photo;
    private long orderNumber;
}
