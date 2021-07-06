package collectionandmap.collection.set;

import collectionandmap.collection.Person;
import java.util.HashSet;

/**
 * hashSet的使用
 */
public class Demo2 {
    public static void main(String[] args) {
        //先进行哈希计算确定在数组中的位置，然后当数组下标的位置有元素是进行equals比较；
        HashSet<Person> hashSet = new HashSet<>();

        hashSet.add(new Person("a",44));
        hashSet.add(new Person("a",44));
        System.out.println(hashSet);
        //如果Person类没有重写toString()方法，则输出地址值[collectionandmap.collection.Person@677327b6,collectionandmap.collection.Person@1540e19d]
        //由于，Person类没有重写hashcode()和equals方法，则可以输出内容一样的对象[Person{name='a'，age=44}, Person{name='a', age=44}]
        //如果仅仅重写了equals方法，则hashcode()根据对象的地址进行哈希运算，这两个匿名对象的地址肯定不一样啊；
    }
}
