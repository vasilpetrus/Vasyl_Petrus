package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}