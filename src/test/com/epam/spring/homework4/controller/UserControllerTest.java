package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.mapper.UserMapper;
import com.epam.spring.homework4.myRepository.UserRepository;
import com.epam.spring.homework4.service.UserService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = UserController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private final String EMAIL = "test@gmail.com";

    @Test
    void getAllUsers() throws Exception {

        UserDTO userDTO = UserDTO
                .builder()
                .email("test@gmail.com")
                .build();

        UserDTO user2DTO = UserDTO
                .builder()
                .email("test2@gmail.com")
                .build();

        when(userService.getAllUsers()).thenReturn(Arrays.asList(userDTO, user2DTO));

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$[1].email").value(user2DTO.getEmail()));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUser() throws Exception {

        UserDTO userDTO = UserDTO
                .builder()
                .email(EMAIL)
                .build();

        when(userService.getUser(EMAIL)).thenReturn(userDTO);

        this.mockMvc
                .perform(get("/user/" + EMAIL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()));
    }

    @Test
    void createUser(){

        User user = new User();
        user.setEmail(EMAIL);

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO userDTO = userMapper.mapUserDTO(user);

        assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    void deleteUser() throws Exception {

        doNothing().when(userService).deleteUser(EMAIL);

        mockMvc.perform(delete("/user/" + EMAIL))
                .andExpect(status().isNoContent());

        verify(userService, times(1)).deleteUser(EMAIL);
    }
}