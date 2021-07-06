package IO.BIO.fileUpload;

import java.io.*;
import java.net.Socket;

/**
 * 文件上传案例的客户端；IO.BIO
 * 来源：本地硬盘
 * 目的地：服务器
 * 为解决问题：为什么读取本地数据和接受服务器数据要用同一个数组bytes来接收，第二次接收的时候数组里还有数据吗？
 */
public class Cli {
    public static void main(String[] args) throws IOException {
        // 创建本地字节输入流,
        FileInputStream fis = new FileInputStream("b.txt");

        // 创建客户端socket对象，在构造方法中绑定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1", 2222);

        // 创建网络字节输出流
        OutputStream os = socket.getOutputStream();

        int len = 0;
        byte [] bytes = new byte[1024];

        // 通过fis通道将1.jpg的字节写入内存的bytes数组上，len表示传输的字节数
        while ((len = fis.read(bytes)) != -1){
            // 通过网络字节输出流传到服务器
            os.write(bytes,0,len);
        }

        // System.out.println("----");
        // System.out.println(new String(bytes));

        // 接受服务器返回的数据
        InputStream is = socket.getInputStream();
        int len1 = is.read(bytes);
        System.out.println(new String(bytes,0,len1));

        // 关闭
        fis.close();
        os.close();
        socket.close();

    }

}
