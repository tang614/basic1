package IO.BIO.fileUpload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传案例的服务器；
 * 来源：客户端
 * 目的地：服务器硬盘
 * 此示例中采用了多线程的方法来解决并发请求的阻塞问题，即每当客户端有一个请求来时就开启一个新的线程，由于线程之间各自运行，一个线程中的阻塞不会影响到其他线程（即其他请求）
 * 采用BIO的缺陷：需要开启很多线程，可能有100线程（客户端连接），只有20个进行了后续的通话，很浪费。
 *              虽然可以采用线程池来解决，但是治标不治本。
 * 解决方案：NIO，一个线程处理多个客户端请求
 */
public class Ser {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象，并绑定一个端口号
        // ServerSocket serverSocket = new ServerSocket(2222); // 和下面两行一个意思
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(2222));

        while (true){
            // 获取客户端的socket对象
            // 服务器不停止的情况下，一直等待客户端的socket对象
            Socket socket = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte [] bytes = new byte[0];
                        bytes = new byte[1024];
                        InputStream is = socket.getInputStream();
                        int len = is.read(bytes);

                        // 通过服务器本地字节输出路上传到本地的硬盘
                        FileOutputStream fos = new FileOutputStream("e.txt");
                        fos.write(bytes);

                        OutputStream os = socket.getOutputStream();
                        os.write("a".getBytes());
                        fos.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // serverSocket.close();
    }
}
