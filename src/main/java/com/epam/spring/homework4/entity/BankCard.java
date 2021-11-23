package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userInformationId;
    private long cardNumber;
    private int expirationYear;
    private int expirationMonth;
    private String cardOwner;
    private int cvv;
    private double balance;
}
