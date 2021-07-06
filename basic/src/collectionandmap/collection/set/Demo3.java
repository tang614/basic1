package collectionandmap.collection.set;

import collectionandmap.collection.Person;

import java.util.*;

/**
 * treeSet的使用:treeSet的基础是二叉树，此集合具有自动排序的功能；
 */
public class Demo3 {
    public static void main(String[] args) {
//        Set<String> set = new TreeSet<>();
//        set.add("a");
//        set.add("B");
//        set.add("d");
//        set.add("c");
//
//        //由于String类已经实现了comparable接口，所以打印出来的顺序的,但是list集合这样不行
//        for (String str : set) {
//            System.out.println(str);
//        }

        //如果Person没有实现Comparable接口，则会报错
        //第一个减去第二个是升序
        TreeSet<Person> people = new TreeSet<>(/*new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        }*/);


        people.add(new Person("a",1));
        people.add(new Person("b",4));
        people.add(new Person("c",3));

        for (Person p : people){
            System.out.println(p);
        }
    }
}
