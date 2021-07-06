package IO.ByteIO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流举例：
 *      从指定文件读取数据
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("b.txt");

        byte[] bytes = new byte[10];
        int a = fis.read(bytes,1,4);
        System.out.println(a);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        System.out.println(new String(bytes));
        // 2
        // 12

//        int i = fis.read(bytes);
//        System.out.println(i);
//        System.out.println(new String(bytes));
//
//        int b = fis.read(bytes);
//        System.out.println(b);
//        System.out.println(new String(bytes));
//        // 数组的前四个数据被替换，在上一次往内存的数组中写数据时最后一个数据时r

//        byte[] bytes = new byte[1024]; //一般为1024及其整数倍
//        int len;
//        while ((len = fis.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }

    }
}
