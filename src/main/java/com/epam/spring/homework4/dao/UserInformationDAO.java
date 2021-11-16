package com.epam.spring.homework4.dao;

import com.epam.spring.homework4.dto.UserInformationDTO;

import java.util.List;

public interface UserInformationDAO {

    UserInformationDTO getUserInformation(long id);

    List<UserInformationDTO> getAllUsersInformation();

    UserInformationDTO createUserInformation(UserInformationDTO userInformationDto);

    UserInformationDTO updateUserInformation(long id, UserInformationDTO userInformationDto);

    void deleteUserInformation(long id);
}
