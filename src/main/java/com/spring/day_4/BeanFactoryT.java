package com.spring.day_4;

import com.spring.day_4.bean.BeanA;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryT {

    public static void main(String[] args) {

        System.getProperties().entrySet().forEach(e -> System.out.println(e.getKey().toString()));


        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("day_4.xml"));

      /*  PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();

        propertyPlaceholderConfigurer.setSystemPropertiesMode(2);

        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("day_4.properties"));



        propertyPlaceholderConfigurer.postProcessBeanFactory(beanFactory);*/

        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();

        beanFactory.setConversionService(new DefaultConversionService());


        BeanA beana = (BeanA) beanFactory.getBean("beanA");


    }
}
