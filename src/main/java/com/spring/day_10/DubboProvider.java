package com.spring.day_10;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.spring.day_10.api.ICatService;
import com.spring.day_10.service.CatService;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class DubboProvider {


    public static void main(String[] args) throws InterruptedException {

        ProviderDeleget.doProvider(20888, "wyc");

    }
}
