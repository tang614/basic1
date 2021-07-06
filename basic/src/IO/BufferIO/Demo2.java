package IO.BufferIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入缓冲流
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        char [] chars = new char[1024];
        int len = 0;
        while ((len = br.read(chars)) != -1){
            System.out.print(new String(chars,0,len));
        }
        br.close();
    }
}
