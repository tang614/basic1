package lambdaandstream.details;

import lambdaandstream.Person;
import org.junit.Test;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 函数式接口内只有一个抽象方法
 */
public class StudyLambda1 {

    //1、无参 无返回值 run();
    @Test
    public void test(){
        Runnable runnable = () -> {
            System.out.println(123);
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    //2、有一参 无返回值，一个参数时,括号可以省略
    @Test
    public void test2(){
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };
        consumer.accept("abc");
    }

    //3、有多个参数，有返回值
    @Test
    public void test3(){
        Comparator<Person> comparator = (x,y)->{
            System.out.println("====");
            return x.getAge() - y.getAge();
        };

        Comparator<Person> comparator1 = (x,y) -> x.getAge() - y.getAge();

    }
}
