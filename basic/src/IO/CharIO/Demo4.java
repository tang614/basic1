package IO.CharIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符输出流（转化流）
 *      参数：字节输出流
 *      该流是FileReader的父类，和FileReader用法一样，区别在于该流可以指定编码类型，如果不写IDEA默认为utf-8
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("您好！！！");
        //osw.flush();
        osw.close();
    }
}
