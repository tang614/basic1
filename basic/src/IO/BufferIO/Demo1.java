package IO.BufferIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出缓冲流
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        bw.write("哈哈哈");
        bw.close();
    }
}
