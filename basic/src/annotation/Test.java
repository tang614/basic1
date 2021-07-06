package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
@MyInterface(name = "tom")
public class Test {
    @MyInterface1(name = "小明")
    public void a(){}
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterface{
    String name();
    int age() default 10;
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterface1{
    String name();
    int age() default 10;
}
