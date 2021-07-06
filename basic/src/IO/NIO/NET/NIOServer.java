package IO.NIO.NET;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 网络服务器端
 *      NIO相较于BIO的优势：同步非阻塞
 */
public class NIOServer {
    public static void main(String[] args) throws Exception{
        // 得到一个ServerSocketChannel对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // ServerSocket socket = serverSocketChannel.socket(); // 得到serverSocket

        // 得到一个Selector对象，监听事件
        Selector selector = Selector.open();

        // 绑定一个端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 设置为非阻塞方式
        serverSocketChannel.configureBlocking(false);

        // 把ServerSocketChannel对象注册到Selector对象，即Selector对象监听accept事件（客户端连接请求事件）
        // 服务器的ServerSocketChannel对象只能监听OP_ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // Selector对象监听
        while (true){
            // 监听客户端,在2秒内监听客户端，返回事件数量
            if (selector.select(2000)==0){
                System.out.println("客户端没有连接请求，我去干其他事啦！");
                continue;
            }

            // 一个事件一个SelectionKey,selector.selectedKeys()返回值为Set<SelectionKey> set
            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
            // Set<SelectionKey> keys = selector.keys();
            // Set<SelectionKey> selectionKeys = selector.selectedKeys();

            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey = selectionKeyIterator.next();

                if (selectionKey.isAcceptable()){   // 客户端连接事件
                    System.out.println("OP_ACCEPT");
                    // SocketChannel socketChannel = (SocketChannel) selectionKey.channel(); // 也可以通过下面的方式获取客户端的socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if (selectionKey.isReadable()){     // 读取客户端数据事件
                    SocketChannel  socketChannel = (SocketChannel)selectionKey.channel();    // selectionKey中带有客户端的通道和缓存
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("客户端发来的数据"+ new String(byteBuffer.array()));
                }

                selectionKeyIterator.remove();  // 指针指向最新的元素，用完后删除
            }
        }
    }
}
