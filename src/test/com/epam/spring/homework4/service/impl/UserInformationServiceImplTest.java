package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.entity.UserInformation;
import com.epam.spring.homework4.mapper.UserInformationMapper;
import com.epam.spring.homework4.myRepository.UserInformationRepository;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UserInformationServiceImplTest {

    @InjectMocks
    private UserInformationServiceImpl userInformationService;

    @Mock
    private UserInformationRepository userInformationRepository;

    @Spy
    private UserInformationMapper userInformationMapper = Mappers.getMapper(UserInformationMapper.class);

    private final long ID = 1;

    @Test
    void getUserInformation() {

        UserInformation userInformation = new UserInformation();
        userInformation.setId(ID);
        when(userInformationRepository.findById(ID)).thenReturn(userInformation);

        UserInformationDTO userInformationDTO = userInformationService.getUserInformation(ID);

        assertEquals(userInformation.getId(), userInformationDTO.getId());
    }

    @Test
    void getAllUsersInformation() {

        UserInformation userInformation1 = new UserInformation();
        UserInformation userInformation2 = new UserInformation();
        userInformation1.setId(ID);
        userInformation2.setId(ID);

        when(userInformationRepository.findAll()).thenReturn(Arrays.asList(userInformation1, userInformation2));

        List<UserInformationDTO> resultList = userInformationService.getAllUsersInformation();

        assertEquals(2, resultList.size());
    }

    @Test
    void createUserInformation() {

        UserInformation userInformation = new UserInformation();
        userInformation.setId(ID);

        when(userInformationRepository.save(any(UserInformation.class))).thenReturn(userInformation);

        UserInformationDTO userInformationDTO = userInformationService.createUserInformation(userInformationMapper.mapUserInformationDTO(userInformation));

        assertEquals(userInformationDTO.getId(), userInformation.getId());
    }

    @Test
    void deleteUserInformation() {

        doNothing().when(userInformationRepository).deleteById(ID);

        userInformationService.deleteUserInformation(ID);

        verify(userInformationRepository, times(1)).deleteById(ID);
    }
}