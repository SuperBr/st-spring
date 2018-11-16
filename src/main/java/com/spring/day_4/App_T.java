package com.spring.day_4;

import com.spring.day_4.bean.MyAvent;
import com.spring.day_4.bean.MyLifecycle;
import com.spring.day_4.bean.MyListener;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class App_T {
    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        GenericApplicationContext context = new GenericApplicationContext(defaultListableBeanFactory);
      /*  ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/message");

        defaultListableBeanFactory.registerSingleton("messageSource", messageSource);
         String message = context.getMessage("test", null, Locale.CHINA);

*/
        defaultListableBeanFactory.registerSingleton("listener", new MyListener());

        defaultListableBeanFactory.registerSingleton("cycle", new MyLifecycle());

        context.refresh();

        context.start();

        context.stop();

        context.close();

        context.isRunning();

        context.publishEvent(new MyAvent(context, "hello"));


    }
}
