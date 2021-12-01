package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.BankCardDTO;
import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.mapper.BankCardMapper;
import com.epam.spring.homework4.myRepository.BankCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class BankCardServiceImplTest {

    @InjectMocks
    private BankCardServiceImpl bankCardService;

    @Mock
    private BankCardRepository bankCardRepository;

    @Spy
    private BankCardMapper bankCardMapper = Mappers.getMapper(BankCardMapper.class);

    private final long ID = 1;

    @Test
    void getBankCard() {

        BankCard bankCard = new BankCard();
        bankCard.setId(ID);
        when(bankCardRepository.findById(ID)).thenReturn(bankCard);

        BankCardDTO bankCardDTO = bankCardService.getBankCard(ID);

        assertEquals(bankCard.getId(), bankCardDTO.getId());
    }

    @Test
    void getAllBankCard() {

        BankCard bankCard1 = new BankCard();
        BankCard bankCard2 = new BankCard();
        bankCard1.setId(ID);
        bankCard2.setId(ID);

        when(bankCardRepository.findAll()).thenReturn(Arrays.asList(bankCard1, bankCard2));

        List<BankCardDTO> resultList = bankCardService.getAllBankCard();

        assertEquals(2, resultList.size());
    }

    @Test
    void createBankCard() {

        BankCard bankCard = new BankCard();
        bankCard.setId(ID);

        when(bankCardRepository.save(any(BankCard.class))).thenReturn(bankCard);

        BankCardDTO bankCardDTO = bankCardService.createBankCard(bankCardMapper.mapBankCardDTO(bankCard));

        assertEquals(bankCardDTO.getId(), bankCard.getId());
    }

    @Test
    void deleteBankCard() {

        doNothing().when(bankCardRepository).deleteById(ID);

        bankCardService.deleteBankCard(ID);

        verify(bankCardRepository, times(1)).deleteById(ID);
    }
}