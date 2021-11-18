package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@Builder
public class RoleDTO {

    @Positive
    private long id;

    private String role;
}
