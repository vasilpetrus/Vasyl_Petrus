package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private long id;
    private long userInformationId;
    private int roleId;
    private String email;
}
