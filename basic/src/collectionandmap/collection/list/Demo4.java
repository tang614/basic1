package collectionandmap.collection.list;

import java.util.LinkedList;

/**
 * ArrayList和LinkedList特有的方法
 *
 * LinkList
 *      peek(),返回链表头元素，不删除；
 *      pop(),返回链表头元素，删除,removeFirst()如果头元素为空，抛出异常
 *      poll(),返回链表头元素，删除，头元素为空，返回null
 *      push(),往链表头部添加元素
 *      add(),往尾部添加元素；
 */
public class Demo4 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("abc");
        linkedList.add("123");
        linkedList.add("345");          // 在链表末尾添加元素
        linkedList.push("qwe");
        System.out.println(linkedList);
//        linkedList.addFirst("aaa"); //添加到链表的头部
//        linkedList.addLast("bbb");  //在链表末尾添加元素
//        linkedList.push("ccc");     //在链表头部添加元素
//        linkedList.peek();
//        System.out.println(linkedList);
//        System.out.println(linkedList.pop());   //返回链表的第一个元素
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        System.out.println(linkedList);
//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());

    }
}
