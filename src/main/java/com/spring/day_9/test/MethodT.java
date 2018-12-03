package com.spring.day_9.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodT {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MethodA methodA = new MethodA();

        for (Method method : MethodA.class.getDeclaredMethods()) {
            if (method.getName().startsWith("sy")) {
                method.setAccessible(true);
                method.invoke(methodA);
            }
        }

    }


}

class MethodA{

    private void syaHello() {
    System.out.println("hello!");
    }
}