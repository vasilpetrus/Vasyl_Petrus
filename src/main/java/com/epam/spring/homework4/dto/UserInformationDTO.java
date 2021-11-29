package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserInformationDTO {

    @Positive
    private long id;

    @NotEmpty(message = "First name should not be empty!")
    @Size(min = 2, max = 30)
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    @Size(min = 2, max = 30)
    private String lastName;

    private String telephone;

    private BankCardDTO bankCard;
}
