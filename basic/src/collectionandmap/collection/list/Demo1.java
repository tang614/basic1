package collectionandmap.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * list接口含有collection的全部方法，同时list允许集合内元素重复，且有序（有下标）；所有参数中含有下标的函数都是list集合特有的；
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("a");  //允许元素重复
        list.add("b");
        list.add("d");
        System.out.println(list);

        /*list.add(0,"b");    //从下标处添加元素
        System.out.println(list);*/

        /*list.addAll(1,list); //从下标处添加集合
        System.out.println(list);*/

        /*list.set(0,"abc");  //修改元素*/

        /*list.remove(0);
        list.replaceAll(e->e.concat("123456")); //在所有元素后添加字符串
        System.out.println(list);*/

        /*String s = list.get(0);
        int i = list.indexOf("a123456");*/    //集合中出现的第一个元素的下标

        List<String> strings = list.subList(1, 3);  //包含起始下标，不包含结束下标
        System.out.println(strings);

        Integer integer = new Integer(10);
        Integer integer1 = new Integer(10);
        System.out.println(integer == integer1);    //false

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); //true

        Integer c = -129;
        Integer d = -129;
        System.out.println(c == d); //false
    }
}
