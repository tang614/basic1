package com.tang.annotationtest.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Annotationconfigtest {
    public static void main(String[] args) {
        //获取ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.tang.annotationtest.test1");
        //通过ioc的getBean()获取bean
        Student student = (Student) applicationContext.getBean("student");
        //Subject subject = (Subject)applicationContext.getBean("subject");
        System.out.println(student);
        //System.out.println(subject);

        //获取ioc中bean的个数
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println(count);

        //获取bean的名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
