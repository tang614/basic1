package IO.ByteIO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流：
 *      通过fos写数据到c.txt  并实现换行
 *      windows \r\n
 *      linux \n
 *      mac \r
 *      IDEA的编辑器可以识别每一种，所以这三种都可以
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c.txt");// 从文件的开头写入，而且之前的数据会消失,所以如果写入空字节数组，就会删除文件数据
        FileOutputStream fos1 = new FileOutputStream("d.txt", true); //表示写入数据时从文件已有数据的末尾写入，而不是开头
        for (int i = 0; i < 10; i++) {
            fos1.write("hello".getBytes());
            fos1.write("\n".getBytes());
        }
        fos.close();
        fos1.close();
    }
}
