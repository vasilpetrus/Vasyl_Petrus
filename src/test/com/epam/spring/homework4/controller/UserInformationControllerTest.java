package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.config.TestConfig;
import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.entity.UserInformation;
import com.epam.spring.homework4.mapper.UserInformationMapper;
import com.epam.spring.homework4.myRepository.UserInformationRepository;
import com.epam.spring.homework4.service.UserInformationService;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(value = UserInformationController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
class UserInformationControllerTest {

    @MockBean
    private UserInformationService userInformationService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserInformationRepository userInformationRepository;

    @Spy
    private UserInformationMapper userInformationMapper = Mappers.getMapper(UserInformationMapper.class);

    private final long ID = 1;

    @Test
    void getAllUsersInformation() throws Exception {

        UserInformationDTO userInformationDTO = UserInformationDTO
                .builder()
                .id(1)
                .build();

        UserInformationDTO userInformation2DTO = UserInformationDTO
                .builder()
                .id(2)
                .build();

        when(userInformationService.getAllUsersInformation()).thenReturn(Arrays.asList(userInformationDTO, userInformation2DTO));

        mockMvc.perform(get("/user-information"))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(userInformationDTO.getId()))
                .andExpect(jsonPath("$[1].id").value(userInformation2DTO.getId()));

        verify(userInformationService, times(1)).getAllUsersInformation();
    }

    @Test
    void getUserInformation() throws Exception {

        UserInformationDTO userInformationDTO = UserInformationDTO
                .builder()
                .id(ID)
                .build();

        when(userInformationService.getUserInformation(ID)).thenReturn(userInformationDTO);

        mockMvc
                .perform(get("/user-information/" + ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userInformationDTO.getId()));
    }

    @Test
    void createUserInformation() {

        UserInformation userInformation = new UserInformation();
        userInformation.setId(ID);

        when(userInformationRepository.save(any(UserInformation.class))).thenReturn(userInformation);

        UserInformationDTO userInformationDTO = userInformationMapper.mapUserInformationDTO(userInformation);

        Assertions.assertEquals(userInformation.getId(), userInformationDTO.getId());
    }

    @Test
    void deleteUserInformation() throws Exception {

        doNothing().when(userInformationService).deleteUserInformation(ID);

        mockMvc.perform(delete("/user-information/" + ID))
                .andExpect(status().isNoContent());

        verify(userInformationService, times(1)).deleteUserInformation(ID);
    }
}