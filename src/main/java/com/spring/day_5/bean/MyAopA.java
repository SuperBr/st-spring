package com.spring.day_5.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wangyongchao
 * @date 2018/11/17  18:09
 */

@Component
@Aspect
public class MyAopA {


    @Pointcut("execution(* com.spring.day_5.bean.*.*(..))")
    public void pointCut() {
        System.out.println(" this is Pointcut!");
    }

    @Before("pointCut()")
    public void before() {

        System.out.println(" this is before!");
    }

    @After("pointCut()")
    public void after() {
        System.out.println(" this is after!");
    }
}
