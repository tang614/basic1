package com.tang.servicezipkinhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZipkinHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinHelloApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/home")
    public String home(){
        return "hello";
    }

    @RequestMapping("/info")
    public String info(){
        return restTemplate.getForObject("http://localhost:1112/home",String.class);
    }

}
