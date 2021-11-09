package com.epam.spring.homework1.pet;

import org.springframework.stereotype.Component;

@Component
public class Spider implements Animal{

    @Override
    public String getAnimal() {
        return this.getClass().getSimpleName();
    }
}
