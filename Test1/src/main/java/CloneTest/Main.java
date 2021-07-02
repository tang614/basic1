package CloneTest;

import java.io.*;

/**
 * 深拷贝与浅拷贝
 * https://www.cnblogs.com/frankcui/p/10811581.html
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Address address = new Address("安徽", 340);
        Person person = new Person("tom", 52, address);
        System.out.println(person);
        Person clone = (Person)person.clone();
        clone.setAge(10);
        clone.getAddress().setNum(100);
        System.out.println(clone);
        System.out.println(person);

    }
}
