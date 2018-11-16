package com.spring.day_1.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:pro_a.properties")
public class BeanE {

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }
}
