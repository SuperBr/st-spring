package com.spring.day_3.bean;

import org.springframework.beans.factory.InitializingBean;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

/**
 * @author wangyongchao
 * @date 2018/11/12  16:24
 */
public class BeanA implements InitializingBean,Destroyable{

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
        this.man = man;
        return this;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet!");
    }


    public void init() {
        System.out.println("init");
    }

    public void destory() {

        System.out.println("destory!");
    }

    public void destroy() throws DestroyFailedException {
        System.out.println("Destroyable!");
    }

    public boolean isDestroyed() {
        return true;
    }
}
