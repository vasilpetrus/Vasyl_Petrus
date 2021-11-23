package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String telephone;
}