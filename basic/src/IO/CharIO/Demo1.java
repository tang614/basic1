package IO.CharIO;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流：
 *      FileReader extend InputStreamReader extend Reader
 *      read()一次读取一个字符，返回该字符对应的十进制编码；
 *      read(char [] 数组名) 一次尽可能的将数组填满，一般为1024
 *      文件读完后，指针到文件末尾，如果在读文件的代码后再读一次则读不到内容
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("a.txt");

//        // 使用read()
//        int len = 0;
//        while ((len = fileReader.read()) != -1){
//            //System.out.println(len); // 这里输出字符对应的编码
//            System.out.println((char)len);
//        }

        // 使用read(char [] 数组名)
        char[] chars = new char[1024];
        int length = 0;
        while ((length = fileReader.read(chars)) != -1){
            System.out.println(new String(chars,0,length));
        }

        // 释放资源
        fileReader.close();
    }
}
