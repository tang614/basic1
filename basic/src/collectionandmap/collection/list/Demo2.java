package collectionandmap.collection.list;

import collectionandmap.collection.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * list集合的排序
 */
public class Demo2 {
    public static void main(String[] args) {
        //string和people本身有比较规则，但是还是按照集合加入的顺序。
        List<String> list = new ArrayList();
        list.add("a");
        list.add("f");
        list.add("d");
        Collections.sort(list);
        System.out.println(list);


        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("1",1));
        people.add(new Person("3",3));
        people.add(new Person("2",2));
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()- o2.getAge();
            }
        });
        System.out.println(people);



        //三种比较方式：

        /*list.sort(new MyCompare());*/
        /*list.sort((e1,e2) -> e1.length()-e2.length());*/  //函数式接口，可以这样写？？
        /*list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });*/
        System.out.println(list);

    }
}

/*
class MyCompare implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
*/
