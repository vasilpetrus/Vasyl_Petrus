package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class BankCardDTO {

    @Positive
    private long id;

    @Positive
    private long userInformationId;

    @NotEmpty(message = "Password should not be empty!")
    private String cardNumber;

    private int expirationYear;

    private int expirationMonth;

    @NotEmpty(message = "Card owner should not be empty!")
    private String cardOwner;

    private int cvv;

    private double balance;
}
