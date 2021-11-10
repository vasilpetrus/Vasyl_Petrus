package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanC {

    @Value("${beanC.name}")
    private String name;

    @Value("${beanC.value}")
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void doMyInit(){
        System.out.println("It`s Init method - beanC");
    }

    public void doMyDestroy(){
        System.out.println("It`s Destroy method - beanC");
    }

    @Override
    public String toString() {
        return "BeanC -> name = " + name + ", value = " + value;
    }
}
