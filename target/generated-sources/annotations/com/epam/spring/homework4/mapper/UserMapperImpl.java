package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.dto.BankCardDTO.BankCardDTOBuilder;
import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.dto.UserDTO.UserDTOBuilder;
import com.epam.spring.homework4.dto.UserInformationDTO;
import com.epam.spring.homework4.dto.UserInformationDTO.UserInformationDTOBuilder;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.entity.User;
import com.epam.spring.homework4.entity.UserInformation;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDTO> mapUsersDto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( mapUserDTO( user ) );
        }

        return list;
    }

    @Override
    public UserDTO mapUserDTO(User user) {
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

    @Override
    public User mapUser(UserDTO userDTO) {
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
}
