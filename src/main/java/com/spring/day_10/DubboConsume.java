package com.spring.day_10;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.spring.day_10.api.ICatService;
import com.spring.day_10.model.Cat;
import com.spring.day_10.service.CatService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DubboConsume {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch count = new CountDownLatch(1);


        ApplicationConfig applicationConfig = new ApplicationConfig();


        applicationConfig.setName("wyc-test-consume");

        applicationConfig.setLogger("slf4j");


        RegistryConfig registryConfig = new RegistryConfig();

        registryConfig.setProtocol("zookeeper");


        registryConfig.setAddress("127.0.0.1:2181");


        applicationConfig.setRegistry(registryConfig);


        ReferenceConfig referenceConfig = new ReferenceConfig();

        referenceConfig.setApplication(applicationConfig);


        referenceConfig.setInterface(ICatService.class);


        ConsumerConfig consumerConfig = new ConsumerConfig();

        consumerConfig.setGroup("wyc-test");




        referenceConfig.setConsumer(consumerConfig);




        ICatService catService = (ICatService) referenceConfig.get();

        while (true) {

            try {
                Thread.sleep(2000);

                System.out.println(catService.printCat(new Cat().setName("cat")));

            } catch (Exception e) {

            }

        }



    }
}
