package createObject;

import java.lang.reflect.Constructor;

//创建对象的多种方法
public class test {
    public static void main(String[] args) throws Exception{
        //

        //2、通过反射创建对象
        //2.1、Class类的newInstance()，调用无参构造
        Person person = Person.class.newInstance();
        //2.2、Constructor类的newInstance()方法
        //Class<?> personClass = Class.forName("createObject");
        //Constructor<?> constructor = personClass.getConstructor(Person.class, String.class, Integer.class);
        //Person tom = (Person) constructor.newInstance("tom", 15);

        //通过克隆的方法

        char i = '1';
        int j = (int)i;
        System.out.println(j);
    }
}
