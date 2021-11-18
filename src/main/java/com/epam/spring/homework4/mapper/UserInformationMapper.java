package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.entity.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserInformationMapper {

    UserInformationMapper INSTANCE = Mappers.getMapper(UserInformationMapper.class);

    List<UserInformationDTO> mapUsersInformationDto(List<UserInformation>users);

    UserInformationDTO mapUserInformationDTO(UserInformation userInformation);

    UserInformation mapUserInformation(UserInformationDTO userInformationDTO);
}
