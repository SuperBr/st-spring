package com.spring.day_3;

import com.spring.day_3.bean.BeanA;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wangyongchao
 * @date 2018/11/12  16:12
 */
public class XmlBeanFactoryT {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("day3_xmlBeanFactory.xml"));
        xmlBeanFactory.setBeanExpressionResolver(new StandardBeanExpressionResolver());

        xmlBeanFactory.addBeanPostProcessor(new MDestructionAwareProcess());

        xmlBeanFactory.addPropertyEditorRegistrar(new MPropertyEditorRegistrar());



        BeanA beanA = (BeanA) xmlBeanFactory.getBean("beanA");

        xmlBeanFactory.destroySingletons();

        BeanA beanA_ = (BeanA) xmlBeanFactory.getBean("beanA");

        System.out.println("stop!");

    }


}
