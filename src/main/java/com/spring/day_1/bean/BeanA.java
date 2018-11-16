package com.spring.day_1.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanA {
    @Autowired
    private BeanB beanB;

    private BeanB beanB1;


    @Autowired
    private void beanB1(BeanB beanB1) {
        this.beanB1=beanB1;
    }
}
