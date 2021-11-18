package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UserDTO {

    @Positive
    private long id;

    @Positive
    private long userInformationId;

    @Positive
    private int roleId;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    @Size(min = 8, max = 25)
    private transient String password;
}
