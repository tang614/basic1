package collectionandmap.map;

import collectionandmap.collection.Person;

import java.util.TreeMap;

/**
 * treeMap的使用：无序，键不可重复，可自动排序(对键自动排序)
 */
public class Demo2 {
    public static void main(String[] args) {

        //String实现了Comparable接口，是可排序的；
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("address","beijing");
        treeMap.put("score","55");
        treeMap.put("name","xiaoming");
        System.out.println(treeMap);

        //如果Person没有重写Comparable，则会报错
        TreeMap<Person,String> treeMap1 = new TreeMap<>();
        treeMap1.put(new Person("tom",45), "123");
        treeMap1.put(new Person("xiao",44), "224");
        System.out.println(treeMap1);

    }
}
