package IO.ByteIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输入流：
 *      fis.read()  一次只读一个字节，返回的就是该字节
 *      fis.read(byte[] bytes,off,len)  将源文件的数据加载到bytes数组内，从数组的第off位开始，一共加载len个
 *      fis.read(byte[] bytes)  尽可能多的将数据填满bytes数组
 *      使用了utf-8编码，字母和数字都是1个字节，汉字3个字节，如果文件中的数据有数字时当作字符而不是数字
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {

        // 测试数据
        FileInputStream fis = new FileInputStream("b.txt");

        byte[] bytes = new byte[10];
        int read = fis.read(bytes, 1, 4);
        for (int i1 = 0; i1 < bytes.length; i1++) {
            System.out.println(bytes[i1]);
        }
        System.out.println(read);


//        // 将E盘下 我们.txt 文件数据加载到工程目录下的 他们.txt
//        FileInputStream fis = new FileInputStream("E:\\我们.txt");
//        FileOutputStream fos = new FileOutputStream("他们.txt");
//
//        byte [] bytes = new byte[1024];
//        int len;
//        while ((len = fis.read(bytes)) != -1) {
//            fos.write(bytes);
//        }
//
//        fos.close();
//        fis.close();


//        FileInputStream fis = new FileInputStream("E:\\我们.txt");
//        FileOutputStream fos = new FileOutputStream("他们.txt");
//
//        int l;
//        while ((l = fis.read()) != -1) {
//            System.out.println(l);
//            fos.write(l);
//        }
//
//        fos.close();
//        fis.close();
    }
}
