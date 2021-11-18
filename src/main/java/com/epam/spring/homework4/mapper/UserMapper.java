package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDTO> mapUsersDto(List<User>users);

    UserDTO mapUserDTO(User user);

    User mapUser(UserDTO userDTO);
}
