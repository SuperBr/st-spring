package com.spring.day_7;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

public class WebFactoryT {

    public static void main(String[] args) {

        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(8080);

        WebServer context = tomcatServletWebServerFactory.getWebServer();

        context.start();
    }
}
