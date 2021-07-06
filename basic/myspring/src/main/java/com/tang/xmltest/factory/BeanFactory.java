package com.tang.xmltest.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {

    private static Properties properties;
    private static Map<String,Object> hashMap = new HashMap<>();

    static {
        try {
            properties = new Properties();
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String daoName) {
        //使用hashMap当作缓存,如果缓存中没有则创建对象
        if (!hashMap.containsKey(daoName)){

            try {
                //获取配置文件中的全限定类名
                String property = properties.getProperty(daoName);
                //通过反射创建对象
                Class aClass = Class.forName(property);
                Object object = aClass.getConstructor().newInstance();
                //获取bean后存入缓存
                hashMap.put(daoName,object);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return hashMap.get(daoName);
    }
}
