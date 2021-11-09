package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Pet {

    @Autowired
    private List<Animal>animals;

//    @Autowired
//    public void setAnimals(Dog dog, Cat cat, Cheetah cheetah, Spider spider) {
//        animals.add(cat);
//        animals.add(cheetah);
//        animals.add(dog);
//        animals.add(spider);
//    }

    public void printPets() {
        for(Animal animal : animals){
            System.out.println(animal.getAnimal());
        }
    }
}
