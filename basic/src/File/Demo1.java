package File;

import java.io.File;

/**
 * file类的构造方法
 */
public class Demo1 {
    public static void main(String[] args) {
        File file = new File("E:\\com\\tang\\a.txt");
        System.out.println(file);

        File file1 = new File("E:\\com", "tang\\a.txt");
        System.out.println(file1);

        File file2 = new File("E:\\com");
        File file3 = new File(file2, "tang\\a.txt");
        System.out.println(file3);
    }
}
