package com.spring.day_4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class App_T {
    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        GenericApplicationContext context = new GenericApplicationContext(defaultListableBeanFactory);
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");

        defaultListableBeanFactory.registerSingleton("messageSource", messageSource);


        context.refresh();


        String message = context.getMessage("test", null, Locale.CHINA);
    }
}
