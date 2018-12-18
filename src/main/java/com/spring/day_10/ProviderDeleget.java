package com.spring.day_10;

import com.alibaba.dubbo.config.*;
import com.spring.day_10.api.ICatService;
import com.spring.day_10.service.CatService;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ProviderDeleget {



    public static void doProvider(Integer port,String group) throws InterruptedException {


        Semaphore semaphore = new Semaphore(0);

        ApplicationConfig applicationConfig = new ApplicationConfig();


        ProviderConfig providerConfig = new ProviderConfig();

        providerConfig.setPort(port);

        providerConfig.setGroup(group);


        applicationConfig.setName("wyc-test");

        applicationConfig.setLogger("slf4j");


        RegistryConfig registryConfig = new RegistryConfig();

        registryConfig.setProtocol("zookeeper");


        registryConfig.setAddress("127.0.0.1:2181");

        //registryConfig.setCluster("cluster");


        applicationConfig.setRegistry(registryConfig);


        ServiceConfig serviceConfig = new ServiceConfig();

        serviceConfig.setProvider(providerConfig);

        serviceConfig.setApplication(applicationConfig);


        serviceConfig.setInterface(ICatService.class);

        serviceConfig.setMethods(new ArrayList<MethodConfig>());


        serviceConfig.setInterface("com.spring.day_10.api.ICatService");

        serviceConfig.setRef(new CatService());


        serviceConfig.export();

        semaphore.acquire();


    }
}