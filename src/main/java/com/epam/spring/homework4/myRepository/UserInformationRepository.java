package com.epam.spring.homework4.myRepository;

import com.epam.spring.homework4.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    UserInformation findById(long id);

    List<UserInformation> findAll();

    UserInformation save(UserInformation userInformation);

    void deleteById(long id);
}
