package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.UserDAO;
import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.myRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        log.info("getUser by email {}", email);
        User user = userRepository.getUser(email);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("get all users");
        return userRepository.getAllUsers()
                .stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDto) {
        log.info("updateUser with email {}", email);
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser by email {}", email);
        userRepository.deleteUser(email);
    }

    private UserDTO mapUserToUserDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userInformationId(user.getUserInformationId())
                .roleId(user.getRoleId())
                .email(user.getEmail())
                .build();
    }

    private User mapUserDtoToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .userInformationId(userDTO.getUserInformationId())
                .roleId(userDTO.getRoleId())
                .email(userDTO.getEmail())
                .build();
    }

}
