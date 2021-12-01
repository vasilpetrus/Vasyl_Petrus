package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.dto.UserOrderDTO.UserOrderDTOBuilder;
import com.epam.spring.homework4.entity.UserOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-30T18:01:46+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class UserOrderMapperImpl implements UserOrderMapper {

    @Override
    public List<UserOrderDTO> mapUsersOrderDto(List<UserOrder> usersOrder) {
        if ( usersOrder == null ) {
            return null;
        }

        List<UserOrderDTO> list = new ArrayList<UserOrderDTO>( usersOrder.size() );
        for ( UserOrder userOrder : usersOrder ) {
            list.add( mapUserOrderDTO( userOrder ) );
        }

        return list;
    }

    @Override
    public UserOrderDTO mapUserOrderDTO(UserOrder userOrder) {
        if ( userOrder == null ) {
            return null;
        }

        UserOrderDTOBuilder userOrderDTO = UserOrderDTO.builder();

        userOrderDTO.id( userOrder.getId() );
        userOrderDTO.address( userOrder.getAddress() );
        userOrderDTO.orderDate( userOrder.getOrderDate() );
        userOrderDTO.deliveryDate( userOrder.getDeliveryDate() );
        userOrderDTO.status( userOrder.getStatus() );

        return userOrderDTO.build();
    }

    @Override
    public UserOrder mapUserOrder(UserOrderDTO userOrderDTO) {
        if ( userOrderDTO == null ) {
            return null;
        }

        UserOrder userOrder = new UserOrder();

        userOrder.setId( userOrderDTO.getId() );
        userOrder.setAddress( userOrderDTO.getAddress() );
        userOrder.setOrderDate( userOrderDTO.getOrderDate() );
        userOrder.setDeliveryDate( userOrderDTO.getDeliveryDate() );
        userOrder.setStatus( userOrderDTO.getStatus() );

        return userOrder;
    }
}
