package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDto);

    UserDTO updateUser(String email, UserDTO userDto);

    void deleteUser(String email);
}
