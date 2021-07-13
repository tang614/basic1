package com.tang;

import com.tang.impl.UserInfoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CustomerApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("customer.xml");
        UserInfoImpl bean = ioc.getBean(UserInfoImpl.class);
        System.out.println(bean.getInfo());

        System.in.read();
    }
}
