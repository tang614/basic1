package com.tang.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    ScheduledServiceHi scheduledServiceHi;

    @GetMapping(value = "/hello")
    public String sayHi(@RequestParam String name) {
        return scheduledServiceHi.sayHiFromClientOne(name);
    }
}
