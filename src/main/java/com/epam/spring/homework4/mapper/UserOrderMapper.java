package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.entity.UserOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserOrderMapper {

    UserOrderMapper INSTANCE = Mappers.getMapper(UserOrderMapper.class);

    List<UserOrderDTO> mapUsersOrderDto(List<UserOrder>usersOrder);

    UserOrderDTO mapUserOrderDTO(UserOrder userOrder);

    UserOrder mapUserOrder(UserOrderDTO userOrderDTO);
}
