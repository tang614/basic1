package ProxyTest;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("tom");
        //StudentProxy studentProxy = new StudentProxy(student);
        //studentProxy.giveMoney();
        StuInvocationHandler stuHandler = new StuInvocationHandler(student);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
        stuProxy.giveMoney();

        Integer a = new Integer('a');
        System.out.println(a);
    }
}
