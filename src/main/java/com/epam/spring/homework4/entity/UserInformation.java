package com.epam.spring.homework4.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInformation {

    private long id;
    private String firstName;
    private String lastName;
    private String telephone;
}