package com.epam.spring.homework4.entity;

import com.epam.spring.homework4.dto.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInformation_id", referencedColumnName = "id")
    private UserInformation userInformation;

    @Column(name = "role_id")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private transient String password;
}
