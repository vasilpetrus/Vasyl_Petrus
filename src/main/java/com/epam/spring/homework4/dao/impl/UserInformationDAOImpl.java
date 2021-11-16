package com.epam.spring.homework4.dao.impl;

import com.epam.spring.homework4.dao.UserInformationDAO;
import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.entity.UserInformation;
import com.epam.spring.homework4.myRepository.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInformationDAOImpl implements UserInformationDAO {

    private final UserInformationRepository userInformationRepository;

    @Override
    public UserInformationDTO getUserInformation(long id) {
        log.info("get user information by id {}", id);
        UserInformation userInformation = userInformationRepository.getUserInformation(id);
        return mapUserInformationToUserInformationDto(userInformation);
    }


    @Override
    public List<UserInformationDTO> getAllUsersInformation() {
        log.info("get all users information");
        return userInformationRepository.getAllUsersInformation()
                .stream()
                .map(this::mapUserInformationToUserInformationDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserInformationDTO createUserInformation(UserInformationDTO userInformationDTO) {
        log.info("create user information with id {}", userInformationDTO.getId());
        UserInformation userInformation = mapUserInformationDTOToUserInformation(userInformationDTO);
        userInformation = userInformationRepository.createUserInformation(userInformation);
        return mapUserInformationToUserInformationDto(userInformation);
    }

    @Override
    public UserInformationDTO updateUserInformation(long id, UserInformationDTO userInformationDto) {
        log.info("update user information with id {}", id);
        UserInformation userInformation = mapUserInformationDTOToUserInformation(userInformationDto);
        userInformation = userInformationRepository.updateUserInformation(id, userInformation);
        return mapUserInformationToUserInformationDto(userInformation);
    }

    @Override
    public void deleteUserInformation(long id) {
        log.info("delete user information by id {}", id);
        userInformationRepository.deleteUserInformation(id);
    }

    private UserInformationDTO mapUserInformationToUserInformationDto(UserInformation userInformation) {
        return UserInformationDTO.builder()
                .id(userInformation.getId())
                .firstName(userInformation.getFirstName())
                .lastName(userInformation.getLastName())
                .telephone(userInformation.getTelephone())
                .build();
    }

    private UserInformation mapUserInformationDTOToUserInformation(UserInformationDTO userInformationDTO) {
        return UserInformation.builder()
                .id(userInformationDTO.getId())
                .firstName(userInformationDTO.getFirstName())
                .lastName(userInformationDTO.getLastName())
                .telephone(userInformationDTO.getTelephone())
                .build();
    }
}