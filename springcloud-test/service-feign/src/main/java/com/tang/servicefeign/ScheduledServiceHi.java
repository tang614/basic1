package com.tang.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient注解还有注册bean的作用，在程序启动时才可生效，所有HiController中注入ScheduledServiceHi会报错，可以使用@Component/@Service注解提前告诉spring会生成一个bean
@FeignClient(value = "service-hi",fallback = ScheduledServiceHiHystric.class)
@Component
public interface ScheduledServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
