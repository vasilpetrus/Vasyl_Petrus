package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDTO {

    private long id;
    private String role;
}
