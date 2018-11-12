package com.spring.day_3.bean;

/**
 * @author wangyongchao
 * @date 2018/11/12  16:24
 */
public class BeanA {

    private String name;

    private Integer age;

    private Boolean man;

    private BeanB beanB;

    public BeanB getBeanB() {
        return beanB;
    }

    public BeanA setBeanB(BeanB beanB) {
        this.beanB = beanB;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanA setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public BeanA setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getMan() {
        return man;
    }

    public BeanA setMan(Boolean man) {
        man = man;
        return this;
    }
}
