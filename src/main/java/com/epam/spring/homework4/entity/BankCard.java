package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bankCard")
@Data
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "userInformationId")
    private long userInformationId;

    @Column(name = "cardNumber")
    private long cardNumber;

    @Column(name = "expirationYear")
    private int expirationYear;

    @Column(name = "expirationMonth")
    private int expirationMonth;

    @Column(name = "cardOwner")
    private String cardOwner;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "balance")
    private double balance;
}
