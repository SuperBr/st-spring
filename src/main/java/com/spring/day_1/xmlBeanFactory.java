package com.spring.day_1;

import com.spring.day_1.bean.BeanA;
import com.spring.day_1.bean.BeanB;
import com.spring.day_1.bean.BeanC;
import com.spring.day_1.bean.BeanE;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wangyongchao
 * @date 2018/11/8  19:24
 */
public class xmlBeanFactory {

    public static void main(String[] args) {

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xmlBeanFactory.xml"));


        //@Autowired
        /*AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();

        autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);

        beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);*/

       /* CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor = new CommonAnnotationBeanPostProcessor();

        commonAnnotationBeanPostProcessor.setResourceFactory(beanFactory);

        commonAnnotationBeanPostProcessor.setBeanFactory(beanFactory);

        beanFactory.addBeanPostProcessor(commonAnnotationBeanPostProcessor);*/

       /* BeanA beanA = (BeanA) beanFactory.getBean("beanA");

        BeanB beanB = (BeanB) beanFactory.getBean("beanB");

        BeanC beanc = (BeanC) beanFactory.getBean("beanC");*/

        // --------------------------@Configuration
        ConfigurationClassPostProcessor configurationClassPostProcessor = new ConfigurationClassPostProcessor();

        configurationClassPostProcessor.postProcessBeanDefinitionRegistry(beanFactory);

        configurationClassPostProcessor.postProcessBeanFactory(beanFactory);



        BeanE beanE = (BeanE) beanFactory.getBean("beanE");
        System.out.println("stop");


    }


}


