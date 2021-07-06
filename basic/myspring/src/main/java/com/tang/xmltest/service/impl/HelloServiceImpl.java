package com.tang.xmltest.service.impl;

import com.tang.xmltest.dao.HelloDao;
import com.tang.xmltest.factory.BeanFactory;
import com.tang.xmltest.service.HelloService;

import java.util.List;

public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("helloDao"));
        }
    }

    private HelloDao helloDao = (HelloDao) BeanFactory.getBean("helloDao");

    @Override
    public List<String> getAll() {
        return helloDao.getAll();
    }
}
