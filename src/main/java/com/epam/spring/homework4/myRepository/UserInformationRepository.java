package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.UserInformation;

import java.util.List;

public interface UserInformationRepository {

    UserInformation getUserInformation(long id);

    List<UserInformation> getAllUsersInformation();

    UserInformation createUserInformation(UserInformation userInformation);

    UserInformation updateUserInformation(long id, UserInformation userInformation);

    void deleteUserInformation(long id);
}
