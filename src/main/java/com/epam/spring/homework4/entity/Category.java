package com.epam.spring.homework4.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private long id;
    private String category;
}
