package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.entity.BankCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BankCardMapper {

    BankCardMapper INSTANCE = Mappers.getMapper(BankCardMapper.class);

    List<BankCardDTO> mapBankCardDto(List<BankCard>bankCards);

    BankCardDTO mapBankCardDTO(BankCard bankCard);

    BankCard mapBankCard(BankCardDTO bankCardDTO);
}
