package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.dto.BankCardDTO.BankCardDTOBuilder;
import com.epam.spring.homework4.dto.OrderDTO;
import com.epam.spring.homework4.dto.OrderDTO.OrderDTOBuilder;
import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.dto.UserDTO.UserDTOBuilder;
import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.dto.UserInformationDTO.UserInformationDTOBuilder;
import com.epam.spring.homework4.dto.UserOrderDTO;
import com.epam.spring.homework4.dto.UserOrderDTO.UserOrderDTOBuilder;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.entity.Order;
import com.epam.spring.homework4.entity.Product;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.entity.UserInformation;
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
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderDTO> mapOrderDto(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( orders.size() );
        for ( Order order : orders ) {
            list.add( mapOrderDTO( order ) );
        }

        return list;
    }

    @Override
    public OrderDTO mapOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTOBuilder orderDTO = OrderDTO.builder();

        orderDTO.id( order.getId() );
        List<Product> list = order.getProduct();
        if ( list != null ) {
            orderDTO.product( new ArrayList<Product>( list ) );
        }
        orderDTO.user( userToUserDTO( order.getUser() ) );
        orderDTO.userOrder( userOrderToUserOrderDTO( order.getUserOrder() ) );
        orderDTO.number( order.getNumber() );

        return orderDTO.build();
    }

    @Override
    public Order mapOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        List<Product> list = orderDTO.getProduct();
        if ( list != null ) {
            order.setProduct( new ArrayList<Product>( list ) );
        }
        order.setUser( userDTOToUser( orderDTO.getUser() ) );
        order.setUserOrder( userOrderDTOToUserOrder( orderDTO.getUserOrder() ) );
        order.setNumber( orderDTO.getNumber() );

        return order;
    }

    protected BankCardDTO bankCardToBankCardDTO(BankCard bankCard) {
        if ( bankCard == null ) {
            return null;
        }

        BankCardDTOBuilder bankCardDTO = BankCardDTO.builder();

        bankCardDTO.id( bankCard.getId() );
        bankCardDTO.cardNumber( String.valueOf( bankCard.getCardNumber() ) );
        bankCardDTO.expirationYear( bankCard.getExpirationYear() );
        bankCardDTO.expirationMonth( bankCard.getExpirationMonth() );
        bankCardDTO.cardOwner( bankCard.getCardOwner() );
        bankCardDTO.cvv( bankCard.getCvv() );
        bankCardDTO.balance( bankCard.getBalance() );

        return bankCardDTO.build();
    }

    protected UserInformationDTO userInformationToUserInformationDTO(UserInformation userInformation) {
        if ( userInformation == null ) {
            return null;
        }

        UserInformationDTOBuilder userInformationDTO = UserInformationDTO.builder();

        userInformationDTO.id( userInformation.getId() );
        userInformationDTO.firstName( userInformation.getFirstName() );
        userInformationDTO.lastName( userInformation.getLastName() );
        userInformationDTO.telephone( userInformation.getTelephone() );
        userInformationDTO.bankCard( bankCardToBankCardDTO( userInformation.getBankCard() ) );

        return userInformationDTO.build();
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.userInformation( userInformationToUserInformationDTO( user.getUserInformation() ) );
        userDTO.role( user.getRole() );
        userDTO.email( user.getEmail() );
        userDTO.password( user.getPassword() );

        return userDTO.build();
    }

    protected UserOrderDTO userOrderToUserOrderDTO(UserOrder userOrder) {
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

    protected BankCard bankCardDTOToBankCard(BankCardDTO bankCardDTO) {
        if ( bankCardDTO == null ) {
            return null;
        }

        BankCard bankCard = new BankCard();

        bankCard.setId( bankCardDTO.getId() );
        if ( bankCardDTO.getCardNumber() != null ) {
            bankCard.setCardNumber( Long.parseLong( bankCardDTO.getCardNumber() ) );
        }
        bankCard.setExpirationYear( bankCardDTO.getExpirationYear() );
        bankCard.setExpirationMonth( bankCardDTO.getExpirationMonth() );
        bankCard.setCardOwner( bankCardDTO.getCardOwner() );
        bankCard.setCvv( bankCardDTO.getCvv() );
        bankCard.setBalance( bankCardDTO.getBalance() );

        return bankCard;
    }

    protected UserInformation userInformationDTOToUserInformation(UserInformationDTO userInformationDTO) {
        if ( userInformationDTO == null ) {
            return null;
        }

        UserInformation userInformation = new UserInformation();

        userInformation.setId( userInformationDTO.getId() );
        userInformation.setFirstName( userInformationDTO.getFirstName() );
        userInformation.setLastName( userInformationDTO.getLastName() );
        userInformation.setTelephone( userInformationDTO.getTelephone() );
        userInformation.setBankCard( bankCardDTOToBankCard( userInformationDTO.getBankCard() ) );

        return userInformation;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setUserInformation( userInformationDTOToUserInformation( userDTO.getUserInformation() ) );
        user.setRole( userDTO.getRole() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    protected UserOrder userOrderDTOToUserOrder(UserOrderDTO userOrderDTO) {
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
