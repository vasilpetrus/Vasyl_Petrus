package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean {

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanA -> name = " + name + ", value = " + value;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("It`s AfterPropertiesSet method - beanA");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("It`s Destroy method - beanA");
    }
}
