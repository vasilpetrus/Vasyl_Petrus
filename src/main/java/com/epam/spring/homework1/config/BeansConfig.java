package com.epam.spring.homework1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(OtherConfig.class)
@ComponentScan("com.epam.spring.homework1.beans")
public class BeansConfig {
}
