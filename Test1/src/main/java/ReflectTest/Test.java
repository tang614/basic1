package ReflectTest;

import app.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Test {

    public static void main(String[] args) {
        Class<Person> c = Person.class;
        Constructor[] constructors;
        constructors = c.getDeclaredConstructors();

        Class[] p = {String.class,Integer.class};
        try {
            Constructor<Person> declaredConstructor = c.getDeclaredConstructor(p);
            System.out.println(declaredConstructor + "00000");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < constructors.length; i++) {
            //
            System.out.print(Modifier.toString(constructors[i].getModifiers()) + "参数:");
            Class[] parameterTypes = constructors[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j].getName());
            }
            System.out.println("");
        }
        //Class[] classes = {String.class};
        //Object[] objects = {"tom"};
        //Class<?> aClass = Class.forName("bean.Person");
        //Object object = ReflectUtils.getObject("bean.Person", String.class, "tom");
        //System.out.println(ReflectUtils.invokeInstanceMethod(object, "toString"));
        //System.out.println(object);

        Object object = ReflectUtils.getObject("app.Person");
        ReflectUtils.invokeInstanceMethod(object,"abc");

    }
}
