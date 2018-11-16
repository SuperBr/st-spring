package com.spring.day_3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author wangyongchao
 * @date 2018/11/13  19:45
 */
public class MDestructionAwareProcess implements DestructionAwareBeanPostProcessor {
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
      System.out.println("this is depostProcessBeforeDestructions");
    }

    public boolean requiresDestruction(Object bean) {
        return true;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
