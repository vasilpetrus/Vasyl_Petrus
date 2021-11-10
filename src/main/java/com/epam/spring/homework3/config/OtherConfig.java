package com.epam.spring.homework3.config;

import org.springframework.context.annotation.*;

@ComponentScan("com.epam.spring.homework3.beans")
@Import(BeansConfig.class)
@Configuration
public class OtherConfig {

}
