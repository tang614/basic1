package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//通过反射，动态的创建对象
public class Demo02 {
    public static void main(String[] args) throws Exception{
        //获得Class对象
        Class c1 = Class.forName("reflection.User");

        //通过无参构造，构造一个对象
        User user = (User)c1.newInstance();
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
        User user2 = (User)constructor.newInstance("小明", 10);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        Method setAge = c1.getDeclaredMethod("setAge", int.class);
        setAge.invoke(user3,10);
        setName.invoke(user3,"李华");
        System.out.println(user3);

        //通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        Field age = c1.getDeclaredField("age");
        //不能直接操作私有属性，关闭安全检测
        name.setAccessible(true);
        age.setAccessible(true);
        name.set(user4,"小红");
        age.set(user4,11);
        System.out.println(user4);


    }
}
