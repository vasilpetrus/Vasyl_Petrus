package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.entity.UserInformation;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserDTO {

    @Positive
    private long id;

    private UserInformationDTO userInformation;

    private Role role;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    @Size(min = 8, max = 25)
    private String password;
}
