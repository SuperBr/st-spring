package com.spring.day_3.bean;

/**
 * @author wangyongchao
 * @date 2018/11/13  20:09
 */
public class BeanC {
    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }

    public BeanC setBeanA(BeanA beanA) {
        this.beanA = beanA;
        return this;
    }
}
