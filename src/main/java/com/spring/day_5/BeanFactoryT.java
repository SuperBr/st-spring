package com.spring.day_5;

import com.spring.day_5.bean.BeanA;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.List;

public class BeanFactoryT {


    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();



        defaultListableBeanFactory.addBeanPostProcessor(new AnnotationAwareAspectJAutoProxyCreator() {

            public AnnotationAwareAspectJAutoProxyCreator init() {
                this.setBeanFactory(defaultListableBeanFactory);
                super.initBeanFactory(defaultListableBeanFactory);
                return this;
            }
        }.init());

        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(defaultListableBeanFactory);

        classPathBeanDefinitionScanner.setIncludeAnnotationConfig(false);

        classPathBeanDefinitionScanner.scan("com.spring.day_5.bean");


        BeanA beanA = (BeanA) defaultListableBeanFactory.getBean("beanA");
        beanA.m();
        beanA.a();
        beanA.b();

    }
}
