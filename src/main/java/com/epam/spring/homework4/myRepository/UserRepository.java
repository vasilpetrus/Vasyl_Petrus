package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    List<User> findAll();

    User save(User user);

    void deleteByEmail(String email);
}