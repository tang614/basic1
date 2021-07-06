package com.tang.annotationtest.test1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("subject1")
public class Subject {

    @Value("马老师")
    private String teacher;
    @Value("语文")
    private String name;
}
