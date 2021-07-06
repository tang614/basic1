package IO.BIO.a;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // 创建客户端socket对象，在构造方法中绑定服务器的ip地址和端口号
        Socket socket = new Socket("127.0.0.1", 2222);

        // 从控制台发送给服务器数据
        System.out.println("请输入你先发送的数据：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        OutputStream os = socket.getOutputStream();
        os.write(s.getBytes());

        // 接受服务器返回的数据
        InputStream is = socket.getInputStream();
        byte [] bytes = new byte[1024];
        int len = is.read(bytes);
         os.write(bytes);
        System.out.println("服务器返回的数据是：" + new String(bytes,0,len));

        //关闭
        socket.close();

    }
}
