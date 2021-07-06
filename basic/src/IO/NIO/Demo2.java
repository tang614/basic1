package IO.NIO;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过NIO实现文件IO：
 *      1、往本地文件写数据
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        // 往本地文件写数据
        // 创建输出流
        FileOutputStream fos = new FileOutputStream("basic.txt");

        // 通过流获取通道
        FileChannel c = fos.getChannel();

        // 获取缓冲区byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 往缓冲区写入数据
        byteBuffer.put("hello".getBytes());

        // 将缓冲区的指针重置到初始位置
        byteBuffer.flip();

        // 把缓冲区数据写道通道中
        c.write(byteBuffer);

        // 关闭流
        fos.close();
    }
}
