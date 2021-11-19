package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.mapper.UserMapper;
import com.epam.spring.homework4.myRepository.UserRepository;
import com.epam.spring.homework4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        log.info("getUser by email {}", email);
        User user = userRepository.getUser(email);
        return UserMapper.INSTANCE.mapUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("get all users");
        return UserMapper.INSTANCE.mapUsersDto(userRepository.getAllUsers());
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.mapUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDto) {
        log.info("updateUser with email {}", email);
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.mapUserDTO(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser by email {}", email);
        userRepository.deleteUser(email);
    }
}
