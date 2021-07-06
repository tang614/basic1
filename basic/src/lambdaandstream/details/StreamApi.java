package lambdaandstream.details;

import lambdaandstream.Person;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 使用Stream流
 */
public class StreamApi {

    @Test
    public void test(){
        //将集合转换为流
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("123");
        Stream<String> stream = list.stream();

        //将数组转化为流
        Integer [] arrays = new Integer[1];
        Stream<Integer> stream1 = Arrays.stream(arrays);

        //匿名数组转换为流
        Stream<String> stream2 = Stream.of("a","b","c");
    }

    @Test
    public void test1(){
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

    //map映射：接收lambda，将元素转为其他形式或提取信息
    //接收一个函数作为参数，该函数会应用到每个元素上，将其映射为一个新的元素
    @Test
    public void test2(){
        Stream<String> stream = Stream.of("abc","afd","ass");
        stream.map((x) -> x.toUpperCase())
                .forEach(System.out::println);

        List<Person> list = new ArrayList<>();
        list.add(new Person(19,170));
        list.add(new Person(22,184));
        list.add(new Person(16,189));
        list.stream().map(Person::getAge).forEach(System.out::println);
    }
}
