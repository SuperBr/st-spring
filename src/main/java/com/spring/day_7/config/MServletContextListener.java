package com.spring.day_7.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("this is contextInitialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
