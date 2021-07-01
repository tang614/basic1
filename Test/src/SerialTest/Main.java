package SerialTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//https://zhuanlan.zhihu.com/p/149252373
public class Main {
    public static void main(String[] args) throws Exception{
        Person tom = new Person("tom", 23, "上海");
        //序列化
        FileOutputStream fileOutputStream = new FileOutputStream("src\\SerialTest\\a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(tom);

        //反序列化
        FileInputStream fileInputStream = new FileInputStream("src\\SerialTest\\a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);
    }
}
