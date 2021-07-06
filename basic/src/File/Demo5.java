package File;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        // 路径分隔符，不同路径之间的分隔符，例E:\a.txt;D:\b.txt
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);

        // 同一个路径之间的分隔符 E:\a\b\c.txt
        String separator = File.separator;
        System.out.println(separator);
    }
}
