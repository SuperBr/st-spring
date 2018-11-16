package com.spring.day_4.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof MyAvent) {
            System.out.println(((MyAvent) event).getMessage());
        }
    }
}
