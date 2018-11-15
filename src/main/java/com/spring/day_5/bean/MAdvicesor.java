package com.spring.day_5.bean;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



public class MAdvicesor implements Advisor {
    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
