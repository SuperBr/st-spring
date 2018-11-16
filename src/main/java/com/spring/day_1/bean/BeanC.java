package com.spring.day_1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BeanC {
    @Resource
    private BeanD beanD;

    private BeanD xBeanD;

    @Resource
    public void getXBeanD(BeanD xBeanD) {
        this.xBeanD = xBeanD;
    }

}
