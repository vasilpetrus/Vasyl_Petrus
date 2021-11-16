package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInformationDTO {

    private long id;
    private String firstName;
    private String lastName;
    private long telephone;
}
