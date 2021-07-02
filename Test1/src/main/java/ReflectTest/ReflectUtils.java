package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Tangzongwei
 * @date 2021/02/25
 */

public class ReflectUtils {

    /**
     * 通过类Class对象、参数类型数组、参数值数组 获取一个类对象；
     *
     * @param clazz
     * @param paraTypes
     * @param paraValues
     * @return
     */
    public static Object getObject(Class clazz,Class[] paraTypes,Object[] paraValues){
        try {
            Constructor constructor = clazz.getDeclaredConstructor(paraTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(paraValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过全限定类名、参数类型数组、参数值数组 获取一个类对象；
     *
     * @param name
     * @param paraTypes
     * @param paraValues
     * @return
     */
    public static Object getObject(String name,Class[] paraTypes,Object[] paraValues){
        try {
            Class clazz = Class.forName(name);
            return getObject(clazz,paraTypes,paraValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过全限定类名 获取类对象（无参）
     *
     * @param name
     * @return
     */
    public static Object getObject(String name){
        try {
            Class[] paraTypes = {};
            Object[] paraValues = {};
            Class clazz = Class.forName(name);
            return getObject(clazz, paraTypes,paraValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过类Class对象 获取类对象（无参）
     *
     * @param clazz
     * @return
     */
    public static Object getObject(Class clazz){
        Class[] paraTypes = {};
        Object[] paraValues = {};
        return getObject(clazz,paraTypes,paraValues);
    }

    /**
     * 通过全限定类名、单个参数类型、单个参数值 获取类对象
     *
     * @param name
     * @param paraType
     * @param paraValue
     * @return
     */
    public static Object getObject(String name,Class paraType, Object paraValue){
        try {
            Class clazz = Class.forName(name);
            Class[] paraTypes = {paraType};
            Object[] paraValues = {paraValue};
            return getObject(clazz,paraTypes,paraValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过类Class对象、单个参数类型、单个参数值 获取类对象
     *
     * @param clazz
     * @param paraType
     * @param paraValue
     * @return
     */
    public static Object getObject(Class clazz,Class paraType, Object paraValue){
        Class[] paraTypes = {paraType};
        Object[] paraValues = {paraValue};
        return getObject(clazz,paraTypes,paraValues);
    }

    /**
     * 通过类对象、方法名、方法参数类型数组、方法参数值数据 执行类对象的方法;
     *
     * @param obj
     * @param methodName
     * @param paraTypes
     * @param paraValues
     * @return
     */
    public static Object invokeInstanceMethod(Object obj,String methodName,Class[] paraTypes,Object[] paraValues){
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, paraTypes);
            return method.invoke(obj,paraValues);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过类对象、方法名、单个方法参数类型、单个方法参数值 执行类对象的方法
     *
     * @param obj
     * @param methodName
     * @param paraType
     * @param paraValue
     * @return
     */
    public static Object invokeInstanceMethod(Object obj,String methodName,Class paraType,Object paraValue){
        Class[] paraTypes = {paraType};
        Object[] paraValues = {paraValue};
        return invokeInstanceMethod(obj,methodName,paraTypes,paraValues);
    }

    /**
     * 通过类对象、方法名 执行无参方法
     *
     * @param obj
     * @param methodName
     * @return
     */
    public static Object invokeInstanceMethod(Object obj,String methodName){
        Class[] paraTypes = {};
        Object[] paraValues = {};
        return invokeInstanceMethod(obj,methodName,paraTypes,paraValues);
    }
}
