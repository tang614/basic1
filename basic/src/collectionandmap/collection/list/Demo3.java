package collectionandmap.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * list集合的遍历
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c");
        System.out.println(list);

        //也可以使用迭代器
        Iterator<String> stringIterator = list.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }


    }
}
