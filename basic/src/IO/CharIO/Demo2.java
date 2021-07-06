package IO.CharIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流：
 *      FileWriter extends OutputStreamWriter extends Writer
 *      write()
 *      write(char [] 数据名)
 *      write(String s)
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 参数也可以传入一个File对象
        FileWriter fileWriter = new FileWriter("a.txt");
        //FileWriter fileWriter = new FileWriter("a.txt",true); // 可以续写

        // 将数据写到内存缓冲区中(字符转换为字节的过程)
        fileWriter.write("大家好！！！");

        // 将内存缓冲区的数据写道文件中
        fileWriter.flush();

        // 刷新缓冲区后可以继续使用流fileWriter
        fileWriter.write(97);

        // 写入数组
        char [] chars = {'a', 'b', 'c'};
        fileWriter.write(chars);

        // 释放资源(将内存缓冲区的数据写道文件中),写了fileWriter.close()可以不写fileWriter.flush();
        fileWriter.close();
    }
}
