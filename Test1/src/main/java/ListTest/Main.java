package ListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 对sublist测试
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list1 = list.subList(1, 4);
        System.out.println(list1);
        System.out.println(list);

        //list1.add(8);//视图发生改变，原集合跟着改变
        //list.add(9);//原集合发生改变，报错

        System.out.println(list1);
        System.out.println(list);
    }
}
