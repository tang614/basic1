package com.tang.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class ScheduledServiceHiHystric implements ScheduledServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
