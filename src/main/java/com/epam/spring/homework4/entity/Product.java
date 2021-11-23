package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long categoryId;
    private String name;
    private String description;
    private Double price;
    private String status;
    private String photo;
    private long orderNumber;
}
