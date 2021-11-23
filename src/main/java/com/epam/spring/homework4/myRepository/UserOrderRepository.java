package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    UserOrder findById(long id);

    List<UserOrder> findAll();

    UserOrder save(UserOrder userOrder);

    void deleteById(long id);
}
