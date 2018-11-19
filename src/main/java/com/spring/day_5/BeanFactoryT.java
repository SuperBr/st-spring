package com.spring.day_5;

import com.spring.day_5.bean.BeanA;
import com.spring.day_5.bean.BeanB;
import com.spring.day_5.bean.InterfaceA;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.io.IOException;
import java.util.List;

public class BeanFactoryT {


    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\mypro\\st-spring\\cglib");

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

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

        BeanB beanb = (BeanB) defaultListableBeanFactory.getBean("beanB");

        InterfaceA beanC = (InterfaceA) defaultListableBeanFactory.getBean("beanC");
        beanA.m();
        beanA.a();
        beanA.b();

        beanC.m();

    }
}
