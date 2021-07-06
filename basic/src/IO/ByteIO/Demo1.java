package IO.ByteIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * 字节输出流：
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //创建文件输出流的同时 new File("f.txt") file.createFile()
        FileOutputStream fos = new FileOutputStream("b.txt");

        // 一次写一个字节
//        fos.write(97);
//        fos.write(48);
//        fos.write(65);
//        fos.close();

//        byte[] bytes = "abcd".getBytes();
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]); // 97 98 99 100 字节打印在控制台是数字（ASCII的十进制）,在文件中是字符
//        }

//        byte[] bytes = "ab".getBytes();
//        fos.write(bytes);

        byte[] bytes = {};
        fos.write(bytes);
    }
}
