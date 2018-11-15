package com.spring.day_5.bean;


import org.springframework.stereotype.Component;

@Component
public class BeanA {


    public void m() {
        System.out.println("m!!");
    }

    public void a() {
        System.out.println("a!!");
    }

    public static void b() {
        System.out.println("b!!");
    }

}
