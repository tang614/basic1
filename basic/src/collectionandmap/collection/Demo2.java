package collectionandmap.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection的遍历,Collection接口继承了Iterator接口
 */
public class Demo2 {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        col.add("a");
        col.add("b");

        //1
        for (String s:col)
            System.out.println(s);

        //2
        col.forEach(s -> System.out.println(s));

        //3
        Iterator<String> iterator = col.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
