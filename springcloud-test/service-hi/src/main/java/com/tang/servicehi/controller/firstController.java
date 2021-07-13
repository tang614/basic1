package com.tang.servicehi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class firstController {

    @RequestMapping("/query")
    @ResponseBody
    public Object query(){
        return new Object();
    }
}
