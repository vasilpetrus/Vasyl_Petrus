package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;
    private Date orderDate;
    private Date deliveryDate;
    private String status;
}
