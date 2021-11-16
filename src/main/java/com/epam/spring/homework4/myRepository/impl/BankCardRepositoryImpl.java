package com.epam.spring.homework4.myRepository.impl;

import com.epam.spring.homework4.entity.BankCard;
import com.epam.spring.homework4.myRepository.BankCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class BankCardRepositoryImpl implements BankCardRepository {

    private final List<BankCard> listBankCard = new ArrayList<>();

    @Override
    public BankCard getBankCard(long id) {
        return listBankCard.stream()
                .filter(bankCard -> bankCard.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Bank card is not found!"));
    }

    @Override
    public List<BankCard> getAllBankCards() {
        return new ArrayList<>(listBankCard);
    }

    @Override
    public BankCard createBankCard(BankCard bankCard) {
        listBankCard.add(bankCard);
        return bankCard;
    }

    @Override
    public BankCard updateBankCard(long id, BankCard bankCard) {
        boolean isDeleted = listBankCard.removeIf(u -> u.getId() == id);
        if (isDeleted) {
            listBankCard.add(bankCard);
        } else {
            throw new RuntimeException("Bank card is not found!");
        }
        return bankCard;
    }

    @Override
    public void deleteBankCard(long id) {
        listBankCard.removeIf(bankCard -> bankCard.getId() == id);
    }
}
