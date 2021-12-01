package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.dto.BankCardDTO.BankCardDTOBuilder;
import com.epam.spring.homework4.entity.BankCard;
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
public class BankCardMapperImpl implements BankCardMapper {

    @Override
    public List<BankCardDTO> mapBankCardDto(List<BankCard> bankCards) {
        if ( bankCards == null ) {
            return null;
        }

        List<BankCardDTO> list = new ArrayList<BankCardDTO>( bankCards.size() );
        for ( BankCard bankCard : bankCards ) {
            list.add( mapBankCardDTO( bankCard ) );
        }

        return list;
    }

    @Override
    public BankCardDTO mapBankCardDTO(BankCard bankCard) {
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

    @Override
    public BankCard mapBankCard(BankCardDTO bankCardDTO) {
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
}
