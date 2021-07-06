package IO.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过NIO实现文件IO（有了通道Channel和缓冲区Buffer的概念）
 *      1、读取本地文件的数据
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        // 从本地文件读取数据
        // 创建输出流
        File file = new File("basic.txt");
        FileInputStream fis = new FileInputStream(file);

        // 通过流获取通道
        FileChannel c = fis.getChannel();

        // 获取缓冲区byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());    // file.length()返回值为long

        // 从缓冲区读取数据
        c.read(byteBuffer);

        // 缓冲区有了数据之后可以打印看看
        System.out.println(new String(byteBuffer.array()));

        // 关闭流
        fis.close();

    }
}
