package com.tang.annotationtest.test1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {
    @Value("123")
    private String id;
    @Value("小明")
    private String name;
    @Autowired
    @Qualifier("subject1")
    private Subject subject;
}
