package IO.BufferIO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节缓冲输出流
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt"));
        bos.write("哈哈哈".getBytes());
        //bos.flush();
        bos.close();
    }
}
