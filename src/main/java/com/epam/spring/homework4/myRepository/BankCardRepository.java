package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.BankCard;

import java.util.List;

public interface BankCardRepository {

    BankCard getBankCard(long id);

    List<BankCard> getAllBankCards();

    BankCard createBankCard(BankCard bankCard);

    BankCard updateBankCard(long id, BankCard bankCard);

    void deleteBankCard(long id);
}
