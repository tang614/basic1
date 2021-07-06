package collectionandmap.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 *collection接口的常用方法
 * collection.removeIf()???
 */
public class Demo1 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("tom");
        collection.add("zhangsan");
        collection.add("1");
        collection.remove("tom");
        System.out.println(collection);

        String[] strings = collection.toArray(new String[4]); //collection集合中只有两个元素，所以数组的后两个为null
        for (String obj:strings){
            System.out.println(obj);
        }

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("a");
        collection1.add("b");
        /*boolean b = collection.addAll(collection1);*/
        collection.addAll(collection1); //返回值为布尔类型
        System.out.println(collection);

        /*collection1.add("c");
        collection.retainAll(collection1);  //collection只保留collection1含有的元素（即两者共有的元素）
        System.out.println(collection);*/

        collection.removeAll(collection1);
        System.out.println(collection);

        int size = collection.size();
        System.out.println(size);

        boolean empty = collection.isEmpty();
        System.out.println(empty);

        boolean tom = collection.contains("tom");
        boolean b = collection.containsAll(collection1);

        collection.clear();

    }
}
