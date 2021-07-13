package com.tang.servicehi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class firstController {

    @Bean
    Person getPerson(){
        return new Person("tom");
    }

    @Autowired
    Person person;

    @RequestMapping("/query")
    @ResponseBody
    public Person query(){
        return person;
    }
}
