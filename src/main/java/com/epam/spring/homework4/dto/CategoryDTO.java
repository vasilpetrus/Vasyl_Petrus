package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.entity.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class CategoryDTO {

    @Positive
    private long id;

    @NotEmpty(message = "Category should not be empty!")
    private String category;
}
