package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanD {

    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void doMyInit(){
        System.out.println("It`s Init method - beanD");
    }

    public void doMyDestroy(){
        System.out.println("It`s Destroy method - beanD");
    }

    @Override
    public String toString() {
        return "BeanD -> name = " + name + ", value = " + value;
    }
}
