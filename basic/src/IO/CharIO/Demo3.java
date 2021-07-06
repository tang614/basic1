package IO.CharIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符输入流（转换流）
 *      参数：字节输入流
 *      该流是FileWriter的父类，和FileWriter用法一样，区别在于该流可以指定编码类型，如果不写IDEA默认为utf-8
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        //InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        char [] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }
    }
}
