package lambdaandstream.details;

import lambdaandstream.Person;
import org.junit.Test;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用与对象引用
 */
public class StudyLambda3 {
    //对象::实例方法名
    @Test
    public void test(){
        Consumer<Integer> consumer = System.out::println;   //等号左边表示这是一个消费型接口实现类，右边可以自己写，也可以用自带的（必须满足有参数，无返回值的要求）
        consumer.accept(123);
    }

    //类名::静态方法
    @Test
    public void test1(){
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x,y);
        Comparator<Integer> comparator1 = Integer::compare;
        int a = comparator.compare(1,2);
        int b = comparator1.compare(1, 2);
        System.out.println(a);
        System.out.println(b);
    }

    //类::实例方法名
    @Test
    public void test2(){
        //需求：比较两个字符串是否相等
        //要求：第一个参数是方法的调用者，第二个参数是方法的参数
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        BiPredicate<String,String> biPredicate1 = String::equals;
        boolean test = biPredicate.test("abc", "abc");
        boolean test1 = biPredicate1.test("ab", "bc");
        System.out.println(test);
        System.out.println(test1);
    }

    //构造器的引用
    @Test
    public void test3(){
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();

        Function<Integer,Person> function = Person::new;    //前面Person类的构造方法中有public Person(Integer age) { this.age = age; }
    }
}
