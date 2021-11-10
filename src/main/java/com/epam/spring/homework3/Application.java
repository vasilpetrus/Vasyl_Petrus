package com.epam.spring.homework3;

import com.epam.spring.homework3.config.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        // Перелік усіх бінів, що створені у ApplicationContext, та їх конфігурація.
        System.out.println("//////////////////////////////////////////////////////////////////////////");
        String[] beansNames = context.getBeanDefinitionNames();
        for (String bean : beansNames) {
                System.out.println(context.getBean(bean).toString());
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////");

        context.close();
    }
}
