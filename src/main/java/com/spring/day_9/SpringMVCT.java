package com.spring.day_9;

import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardWrapper;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * @author wangyongchao
 * @date 2018/11/20  9:35
 */
public class SpringMVCT {

    public static void main(String[] args) {

        TomcatServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory(8089);

        webServerFactory.setBaseDirectory(new File("E:\\myproject\\maven\\st-spring\\src\\main\\resources"));

        webServerFactory.addContextCustomizers(e -> {
           /* e.addApplicationListener("org.springframework.web.context.ContextLoaderListener");
            e.addParameter("contextConfigLocation", "classpath:WEB-INF/applicationContext.xml");*/

            e.setDocBase("E:\\myproject\\maven\\st-spring\\src\\main\\resources");

            Wrapper wrapper = e.createWrapper();
            e.addChild(wrapper);


            wrapper.setName("dispatcher");

            wrapper.setServlet(new DispatcherServlet());

            wrapper.addMapping("/*");
            wrapper.setLoadOnStartup(0);


        });


        WebServer server = webServerFactory.getWebServer();


        server.start();

    }


}
