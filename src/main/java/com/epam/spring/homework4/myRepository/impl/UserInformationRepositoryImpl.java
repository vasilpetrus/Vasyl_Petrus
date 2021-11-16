package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.UserInformation;
import com.epam.spring.homework4.myRepository.UserInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Component
public class UserInformationRepositoryImpl implements UserInformationRepository {

    private final List<UserInformation> listUserInformation = new ArrayList<>();

    @Override
    public UserInformation getUserInformation(long id) {
        return listUserInformation.stream()
                .filter(userInformation -> userInformation.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User information is not found!"));
    }

    @Override
    public List<UserInformation> getAllUsersInformation() {
        return new ArrayList<>(listUserInformation);
    }

    @Override
    public UserInformation createUserInformation(UserInformation userInformation) {
        listUserInformation.add(userInformation);
        return userInformation;
    }

    @Override
    public UserInformation updateUserInformation(long id, UserInformation userInformation) {
        boolean isDeleted = listUserInformation.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listUserInformation.add(userInformation);
        } else {
            throw new RuntimeException("User information is not found!");
        }
        return userInformation;
    }

    @Override
    public void deleteUserInformation(long id) {
        listUserInformation.removeIf(userInformation -> userInformation.getId() == id);
    }
}
