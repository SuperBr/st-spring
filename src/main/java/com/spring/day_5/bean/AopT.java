package com.spring.day_5.bean;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangyongchao
 * @date 2018/11/19  14:36
 */
public class AopT {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\mypro\\st-spring\\cglib");

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SourceA.class);
        enhancer.setCallbacks(new MethodInterceptor[]{new MethIntercepterA(), new MethIntercepterB()});

        enhancer.setInterceptDuringConstruction(false);

        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("M")) {

                    return 0;
                }
                return 1;
            }
        });

        SourceA sourceA= (SourceA) enhancer.create();

        sourceA.methodM();

       /* for (Method method : sourceA.getClass().getMethods()) {
            System.out.println(method.getName());
        }*/

        sourceA.getClass().newInstance();

    }


    public static class MethIntercepterA implements MethodInterceptor {


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("this is intercepter a");

            methodProxy.invokeSuper(objects, objects);

            return o;
        }
    }

    public static class MethIntercepterB implements MethodInterceptor {





        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("this is intercepter b:" + method.getName());

            methodProxy.invokeSuper(o, objects);

            return o;
        }
    }



}
class SourceA{

    public SourceA() {
        System.out.println("this is new ");
        this.methodM();
    }

    public void methodM() {
        System.out.println("this is method m!");

    }



}