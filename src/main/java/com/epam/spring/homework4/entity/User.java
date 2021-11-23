package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userInformationId;

    private Integer role;

    private String email;

    private String password;
}
