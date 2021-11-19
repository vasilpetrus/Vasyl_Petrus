package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.entity.UserInformation;
import com.epam.spring.homework4.mapper.UserInformationMapper;
import com.epam.spring.homework4.myRepository.UserInformationRepository;
import com.epam.spring.homework4.service.UserInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInformationServiceImpl implements UserInformationService {

    private final UserInformationRepository userInformationRepository;

    @Override
    public UserInformationDTO getUserInformation(long id) {
        log.info("get user information by id {}", id);
        UserInformation userInformation = userInformationRepository.getUserInformation(id);
        return UserInformationMapper.INSTANCE.mapUserInformationDTO(userInformation);
    }


    @Override
    public List<UserInformationDTO> getAllUsersInformation() {
        log.info("get all users information");
        return UserInformationMapper.INSTANCE.mapUsersInformationDto(userInformationRepository.getAllUsersInformation());
    }

    @Override
    public UserInformationDTO createUserInformation(UserInformationDTO userInformationDTO) {
        log.info("create user information with id {}", userInformationDTO.getId());
        UserInformation userInformation = UserInformationMapper.INSTANCE.mapUserInformation(userInformationDTO);
        userInformation = userInformationRepository.createUserInformation(userInformation);
        return UserInformationMapper.INSTANCE.mapUserInformationDTO(userInformation);
    }

    @Override
    public UserInformationDTO updateUserInformation(long id, UserInformationDTO userInformationDto) {
        log.info("update user information with id {}", id);
        UserInformation userInformation = UserInformationMapper.INSTANCE.mapUserInformation(userInformationDto);
        userInformation = userInformationRepository.updateUserInformation(id, userInformation);
        return UserInformationMapper.INSTANCE.mapUserInformationDTO(userInformation);
    }

    @Override
    public void deleteUserInformation(long id) {
        log.info("delete user information by id {}", id);
        userInformationRepository.deleteUserInformation(id);
    }
}