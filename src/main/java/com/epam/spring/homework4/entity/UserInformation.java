package com.epam.spring.homework4.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userInformations")
@Data
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankCard_id", referencedColumnName = "id")
    private BankCard bankCard;
}