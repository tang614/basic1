package lambdaandstream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * lambda表达式
 */
public class test {

    @Test
    public void test1(){

        //第一种：先创建接口实现类对象，把对象当作参数传入；
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(1);
        System.out.println(treeSet);

        //第二种：在传入参数的地方new接口（创建匿名实现类对象）
        TreeSet<Integer> treeSet1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(1);
        System.out.println(treeSet);

        //第三种：使用lambda表达式
        TreeSet<Integer> treeSet2 = new TreeSet<>((o1,o2)->Integer.compare(o1,o2));
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(1);
        System.out.println(treeSet);
    }

    /**
     * 删选出所有年纪大于18的人
     * @param list
     * @return
     */
    public List<Person> filterPerson(List<Person> list){
        List<Person> result = new ArrayList<>();
        for (Person person : list) {
            if(person.getAge() > 18)
                result.add(person);
        }
        return result;
    }

    @Test
    public void test2(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(19,170));
        list.add(new Person(22,184));
        list.add(new Person(16,189));

        List<Person> people = filterPerson(list);
        System.out.println(people);
    }

    /**
     *
     * @param list
     * @return
     */
    public List<Person> filterPerson1(List<Person> list,MyPredicate<Person> myPredicate){
        List<Person> result = new ArrayList<>();
        for (Person person : list) {
            if (myPredicate.test(person))
                result.add(person);
        }
        return result;
    }

    @Test
    public void test3(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(19,170));
        list.add(new Person(22,184));
        list.add(new Person(16,189));

        /*List<Person> people = filterPerson1(list, new MyPredicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() > 18;
            }
        });*/

        List<Person> people = filterPerson1(list,(x)->x.getAge() > 18);
        List<Person> result = filterPerson1(people,(x)->x.getHeight() > 180);//在第一次筛选的基础上
        System.out.println(result);
    }

    /**
     * 使用stream流进行筛选
     */
    @Test
    public void test4(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(19,170));
        list.add(new Person(22,184));
        list.add(new Person(16,189));

        //forEach是终止操纵；
        //流是惰性求值，执行到forEach之前，流记录了操作流程，当到达forEach时一次性执行完；
        list.stream()
                .filter((x)->x.getAge() > 18)
                .filter((x)->x.getHeight() > 180)
                .forEach(System.out::println);
    }


}
