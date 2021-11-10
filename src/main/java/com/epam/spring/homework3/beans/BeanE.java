package com.epam.spring.homework3.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println("It`s Init method - beanE");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("It`s Destroy method - beanE");
    }

    @Override
    public String toString() {
        return "BeanE -> name = " + name + ", value = " + value;
    }
}
