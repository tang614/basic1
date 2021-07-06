package IO.BIO.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、在客户/服务器通信模式中，服务器端需要创建监听特定端口的ServerSocket，ServerSocket负责接收客户连接请求，并生成与客户端连接的Socket。
 * 2、在此例子中，如果有多个客户端访问本服务器，获取到第一个客户端的连接后（客户端一直不发数据）则阻塞在第二个地方，此时，第二个客户端请求连接就连接不上了。
 * 3、解决方案：每一个客户端连接时开启一个线程，第一个客户端的连接后的阻塞不会影响其他客户端的连接，看BIO/fileUpload包中的例子。
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象，并绑定一个端口号
        ServerSocket serverSocket = new ServerSocket(2222);
        System.out.println("服务器已启动...");

        // 获取客户端的socket对象
        // 服务器主动监听是否有客户端的请求
        Socket socket = serverSocket.accept();      // 第一个可能阻塞的地方
        System.out.println("已连接...");

        // 读取客户端数据并打印
        System.out.println("正在等待客户端发来数据...");
        InputStream is = socket.getInputStream();
        byte [] bytes = new byte[1024];
        int len = is.read(bytes);                   // 第二个可能阻塞的地方
        System.out.println("客户端发来的数据是：" + new String(bytes,0,len));

        // 返回给客户端数据
        OutputStream os = socket.getOutputStream();
        os.write("谢谢".getBytes());

        // 关闭
        socket.close();
        serverSocket.close();
    }
}
