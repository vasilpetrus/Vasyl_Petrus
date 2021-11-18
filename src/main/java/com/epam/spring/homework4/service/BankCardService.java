package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.BankCardDTO;

import java.util.List;

public interface BankCardService {

    BankCardDTO getBankCard(long id);

    List<BankCardDTO> getAllBankCard();

    BankCardDTO createBankCard(BankCardDTO bankCardDto);

    BankCardDTO updateBankCard(long id, BankCardDTO bankCardDto);

    void deleteBankCard(long id);
}
