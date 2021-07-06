package File;

import java.io.File;
import java.io.IOException;

/**
 * 文件的删除功能
 *      如果一个目录下有内容，则不能直接删除该目录，应该先删除目录中的文件，在删除目录
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        file.createNewFile();   // 通过file创建对象时，此时默认在项目目录下，如果此项目下还有模块model,则此文件和模块同级
        //file.delete();
    }
}
