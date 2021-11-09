package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanC {

    //Значення цього біна буде null, думаю по тій причині, що поля ініціалізуються в першу чергу, ніж біни
    @Autowired
    private BeanC beanC;

    public OtherBeanC(){
        System.out.println(beanC);
    }
}
