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
        UserInformation userInformation = userInformationRepository.findById(id);
        return UserInformationMapper.INSTANCE.mapUserInformationDTO(userInformation);
    }


    @Override
    public List<UserInformationDTO> getAllUsersInformation() {
        log.info("get all users information");
        return UserInformationMapper.INSTANCE.mapUsersInformationDto(userInformationRepository.findAll());
    }

    @Override
    public UserInformationDTO createUserInformation(UserInformationDTO userInformationDTO) {
        log.info("create user information");
        UserInformation userInformation = UserInformationMapper.INSTANCE.mapUserInformation(userInformationDTO);
        userInformation = userInformationRepository.save(userInformation);
        return UserInformationMapper.INSTANCE.mapUserInformationDTO(userInformation);
    }

    @Override
    public void deleteUserInformation(long id) {
        log.info("delete user information by id {}", id);
        userInformationRepository.deleteById(id);
    }
}