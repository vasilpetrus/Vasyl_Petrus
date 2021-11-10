package com.epam.spring.homework3.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class CustomUserBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ExampleBean) {
            if (((ExampleBean) bean).getName() != null && ((ExampleBean) bean).getValue() > 0) {
                System.out.println(beanName + " - VALID!");
            } else {
                System.out.println(beanName + " - NOT VALID!");
            }
        }
            return bean;
        }
}
