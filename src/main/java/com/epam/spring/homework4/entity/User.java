package com.epam.spring.homework4.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private long id;
    private long userInformationId;
    private int roleId;

    private String email;
    private transient String password;
}
