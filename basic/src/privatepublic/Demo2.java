package privatepublic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(4);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list);
        System.out.println(list);

        Person[] people = new Person[4];
        people[0] = p1;
        people[1] = p2;
        people[2] = p3;
        people[3] = p4;
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        int [] a = {2, 4, 5, 3};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        /*thread.Demo1 demo1 = new thread.Demo1();
        demo1.a = 2;
        System.out.println(demo1.a);*/

        Demo5 demo5 = new Demo5();
        /*demo5.a;*/


    }
}
