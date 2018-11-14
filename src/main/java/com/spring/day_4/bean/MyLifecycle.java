package com.spring.day_4.bean;

import org.springframework.context.LifecycleProcessor;

public class MyLifecycle implements LifecycleProcessor {
    @Override
    public void onRefresh() {
        System.out.println("fresh");
    }

    @Override
    public void onClose() {
        System.out.println("close");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop!");
    }

    @Override
    public boolean isRunning() {
        System.out.println("is run?");
        return true;
    }
}
