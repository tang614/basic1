package collectionandmap.collection.set;

import java.util.HashSet;

/**
 * set接口:   无序、不可重复
 * set集合、hashset集合没有比collection特有的方法；
 * hashset的基础是哈希表；哈希表 = 数组 + 单项链表；
 * hashset保证对象唯一的方式：hashcode()和equals()
 * Object类中的hashcode()返回对象在内存中的地址值
 */
public class Demo1 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(16);
        hashSet.add(26);
        hashSet.add(18);
        hashSet.add(6);
        System.out.println(hashSet);
    }
}
