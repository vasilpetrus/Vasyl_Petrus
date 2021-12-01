package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.mapper.UserMapper;
import com.epam.spring.homework4.myRepository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private final String EMAIL = "test@gmail.com";

    @Test
    void getUser() {

        User user = new User();
        user.setEmail(EMAIL);
        when(userRepository.findByEmail(EMAIL)).thenReturn(user);

        UserDTO userDTO = userService.getUser(EMAIL);

        assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    void getAllUsers() {

        User user1 = new User();
        User user2 = new User();
        user1.setEmail(EMAIL);
        user2.setEmail(EMAIL);

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<UserDTO> resultList = userService.getAllUsers();

        assertEquals(2, resultList.size());
    }

    @Test
    void createUser() {

        User user = new User();
        user.setEmail(EMAIL);

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO userDTO = userService.createUser(userMapper.mapUserDTO(user));

        assertEquals(userDTO.getEmail(), user.getEmail());
    }

    @Test
    void deleteUser() {

        doNothing().when(userRepository).deleteByEmail(EMAIL);

        userService.deleteUser(EMAIL);

        verify(userRepository, times(1)).deleteByEmail(EMAIL);
    }
}