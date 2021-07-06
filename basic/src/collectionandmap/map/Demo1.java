package collectionandmap.map;

import java.util.*;

/**
 * map接口的实现类hashMap(类似与hashTable)和treeMap的使用
 * hashMap:无序，健不能重复
 */
public class Demo1 {
    public static void main(String[] args) {

        //不报错，覆盖原有的值
        Map map = new Hashtable();
        map.put(1,2);
        map.put(1,1);
        System.out.println(map);

        System.out.println("========");

        //不报错，覆盖原有的值
        Map map1 = new HashMap();
        map1.put(null,null);
        map1.put(null,2);
        map1.put(1,3);
        map1.putIfAbsent(1,4);          //如果存在了重名的键，则不添加该键值对
        //System.out.println(map1);
        Object put = map1.put(1, 2);    //因为键重复了，所以返回上一个元素的值即3
        //System.out.println(put);
        //System.out.println(map1);
        //map1.remove(1);               //通过键删除
        //map1.remove(null,2);          //通过键值对删除
        //map1.replace(1,3);            //通过健替换值
        //Object o = map1.get(1);       //通过健取值
        //boolean b = map1.containsKey(1);//判断是否含有某个健
        Collection values = map1.values();//获取所有的值
        boolean empty = map1.isEmpty();
        map1.clear();

        System.out.println("========");

        Map<String,String> map2 = new HashMap<>();
        map2.put("address","beijing");
        map2.put("score","100");
        map2.replaceAll((k,v)->{
            if (k.equals("address"))
                return "shangahai";
            return v;
        });
        System.out.println(map2);

        Set<String> strings = map2.keySet();//所有健的集合
        for (String string : strings) {
            System.out.println(string);
        }

        //map集合的遍历
        map2.forEach((k,v)->{   //函数式接口
            System.out.println(k+"="+v);
        });

        //map集合的遍历
        Set<Map.Entry<String, String>> entries = map2.entrySet();
        for (Map.Entry<String,String> en:entries) {
            String key = en.getKey();
            String value = en.getValue();
            System.out.println(key + "==" + value);
        }
    }
}
