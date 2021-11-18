package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
public class CategoryDTO {

    @Positive
    private long id;

    @NotEmpty(message = "Category should not be empty!")
    private String category;
}
