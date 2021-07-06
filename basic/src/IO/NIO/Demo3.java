package IO.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 实现文件的复制
 *      将项目目录下的basic.txt文件复制到C:\basic.txt
 */
public class Demo3 {
    public static void main(String[] args)  throws Exception{
        FileInputStream fis = new FileInputStream("basic.txt");
        FileOutputStream fos = new FileOutputStream("C:\\basic.txt");

        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        fosChannel.transferFrom(fisChannel,0,fisChannel.size());

        fis.close();
        fos.close();
    }
}
