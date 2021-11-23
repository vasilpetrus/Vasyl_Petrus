package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long productId;

    private long userId;

    private long userOrderId;

    private String number;
}
