package File;

import java.io.File;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");

        //是否为真实目录
        System.out.println(file.isDirectory());

        //是否为真实文件
        System.out.println(file.isFile());

        // 该目录或文件是否在电脑上存在
        System.out.println(file.exists());

        // 获取绝对路径
        System.out.println(file.getAbsolutePath());

        //
        File file1 = new File("E:\\tang\\");
        file1.mkdir();

        // 在tang目录下创建文件
        File file2 = new File(file1, "b.txt");
        file2.createNewFile();

        // 在tang目录下创建目录
        File file3 = new File(file1, "hhh");
        file3.mkdir();

        // 此时tang目录下有文件a.txt 和目录hhh
        // tang目录中文件和目录的字符串名称
        String[] list = file1.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        File[] files = file1.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        System.out.println(file1.getPath());
        System.out.println(file1.getName());
    }
}
