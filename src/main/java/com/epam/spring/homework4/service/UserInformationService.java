package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserInformationDTO;

import java.util.List;

public interface UserInformationService {

    UserInformationDTO getUserInformation(long id);

    List<UserInformationDTO> getAllUsersInformation();

    UserInformationDTO createUserInformation(UserInformationDTO userInformationDto);

    void deleteUserInformation(long id);
}
