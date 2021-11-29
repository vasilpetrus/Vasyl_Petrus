package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
public class BankCardDTO {

    @Positive
    private long id;

    @NotEmpty(message = "Password should not be empty!")
    private String cardNumber;

    private int expirationYear;

    private int expirationMonth;

    @NotEmpty(message = "Card owner should not be empty!")
    private String cardOwner;

    private int cvv;

    private double balance;
}
