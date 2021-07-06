package collectionandmap;

import java.util.ArrayList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> iterator = list.iterator();
        String next = iterator.next();
        iterator.remove();

        System.out.println(list);
        String s = list.toString();
        System.out.println(s);

    }
}
