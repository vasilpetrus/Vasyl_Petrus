package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanB implements ExampleBean{

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void someMethod(){
        System.out.println("It`s Some method - beanB");
    }

    public void doMyInit(){
        System.out.println("It`s Init method - beanB");
    }

    public void doMyDestroy(){
        System.out.println("It`s Destroy method - beanB");
    }

    @Override
    public String toString() {
        return "BeanB -> name = " + name + ", value = " + value;
    }
}
