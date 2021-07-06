package IO.BufferIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节缓冲输入流
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        byte [] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
        bis.close();
    }
}
