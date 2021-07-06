package lambdaandstream.details;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class StudyLambda2 {

    //消费性Consumer
    //传入一个参数做具体的业务
    public void happy(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    @Test
    public void test(){
        happy(1000,(x) -> {System.out.println("消费了" + x);});
    }

    //供给型接口Supplier
    //产生指定数量的整数
    public List<Integer> getNumbers(Integer count, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void test2(){
        List<Integer> result = getNumbers(5,()->(int)(Math.random()*100));
        result.forEach(System.out::println);
    }

    //函数式接口Function<T,R> T表示传入参数的类型，R表示返回值类型
    //对传入的参数做一定的改变后返回
    public String getStr(String str, Function<String,String> function){
        return function.apply(str);
    }

    @Test
    public void test3(){
        String result = getStr("小明",(x) -> x+"真帅！！！");
        System.out.println(result);
    }
}
