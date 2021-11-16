package com.epam.spring.homework4.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankCard {

    private long id;
    private long userInformationId;
    private long cardNumber;
    private int expirationYear;
    private int expirationMonth;
    private String cardOwner;
    private int cvv;
    private double balance;
}
