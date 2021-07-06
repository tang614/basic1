package IO.NIO.NET;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 网络客户端
 *      NIO时同步非阻塞的
 */
public class NIOClient {
    public static void main(String[] args) throws Exception{
        // 得到一个网络通道
        SocketChannel channel = SocketChannel.open();

        // 设置非阻塞方式
        channel.configureBlocking(false);

        // 提供服务器端的ip地址和端口号，并封装成一个对象
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);

        // 连接服务器
        if (!channel.connect(address)){
            while (!channel.finishConnect()){
                System.out.println("在连接服务器的同时，也可以干其他事情");   // NIO作为非阻塞的优势，如果时普通的IO连接，连不上持续尝试连接的同时是阻塞的，不能干其他事情
            }
        }

        // 得到一个缓冲区并存入数据
        ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes());

        // 发送数据
        channel.write(buffer);

        System.in.read();
    }
}
