package string;

/**
 * string类的常用方法
 *      字符串切割
 *      生成字串
 */
public class a {
    public static void main(String[] args) {
        String s = "aaa_bbb_baaa";
        System.out.println(s.lastIndexOf("_"));
        System.out.println(s.substring(1));
        String[] strings = s.split("_");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
