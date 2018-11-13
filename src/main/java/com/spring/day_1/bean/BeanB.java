package com.spring.day_1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanB {
    @Autowired
    private BeanA beanA;
}
