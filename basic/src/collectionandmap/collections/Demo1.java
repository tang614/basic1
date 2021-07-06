package collectionandmap.collections;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections是java.util下的工具类
 */
public class Demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,5,4,55,21);
        System.out.println(list);
        Integer max = Collections.max(list);    //list集合中的元素必须是可比较的（实现了Comparable接口）
        Integer max1 = Collections.max(list, (num1, num2) -> num2 - num1);  //如果集合中的元素没有实现Comparable接口，则可以自己定义比较规则
        System.out.println(max);
        System.out.println(max1);

        /*Collections.shuffle(list);  //打乱集合中元素的顺序
        System.out.println(list);*/

        /*Collections.swap(list,1,2); //将集合中下标为1的元素和下标为2的元素交换
        System.out.println(list);*/

        Collections.reverse(list);  //倒序
        System.out.println(list);

        Collections.sort(list); //list集合中的元素必须是可比较的（实现了Comparable接口），默认为从从小到大排序
        System.out.println(list);

        Collections.sort(list,(num1,num2)->num2-num1);//如果集合中的元素没有实现Comparable接口，则可以自己定义比较规则
    }
}
