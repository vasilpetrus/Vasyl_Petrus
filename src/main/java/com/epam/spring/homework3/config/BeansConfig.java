package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.epam.spring.homework3.beans")
public class BeansConfig {

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod = "doMyInit", destroyMethod = "doMyDestroy")
    @DependsOn({"beanD"})
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean(initMethod = "doMyInit", destroyMethod = "doMyDestroy")
    @DependsOn({"beanB"})
    public BeanC beanC(){
        return new BeanC();
    }

    @Bean(initMethod = "doMyInit", destroyMethod = "doMyDestroy")
    public BeanD beanD(){
        return new BeanD();
    }

    @Bean
    public BeanE beanE(){
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }
}
