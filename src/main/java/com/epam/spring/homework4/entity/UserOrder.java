package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_orders")
@Data
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "orderdata")
    private Date orderDate;

    @Column(name = "deliverydate")
    private Date deliveryDate;

    @Column(name = "status")
    private String status;
}
