package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {

    BankCard findById(long id);

    List<BankCard> findAll();

    BankCard save(BankCard bankCard);

    void deleteById(long id);
}
