package File;

import java.io.File;
import java.io.IOException;

/**
 * 创建功能：
 *      mkdir()
 *      mkdirs()
 *      createNewFile()
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {

        File file1 = new File("E:\\com");
        System.out.println(file1);
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);

        File file = new File("E:\\com\\a.txt");
        System.out.println(file);

        boolean newFile = file.createNewFile();
        System.out.println(newFile);

        File file2 = new File("E:\\a\\b");
        boolean mkdir1 = file2.mkdirs();

    }
}
