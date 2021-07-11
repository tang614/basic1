package com.tang;

import com.tang.impl.UserinfoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("customer.xml");
        UserinfoImpl bean = ioc.getBean(UserinfoImpl.class);
        System.out.println(bean.getInfo());
    }
}
