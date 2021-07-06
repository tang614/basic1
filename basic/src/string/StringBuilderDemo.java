package string;

/**
 * 构造方法
 * append()方法
 * 字符串反转
 * StringBuilder和String的相互转化
 * 未加锁，速度快
 */
public class StringBuilderDemo {
    public static void main(String[] args) {

        // 有参构造
        StringBuilder stringBuilder = new StringBuilder("hello");

        // 无参构造
        StringBuilder stringBuilder1 = new StringBuilder();

        // append()
        // 操作完字符串后返回本身的方法可以采用链式编程
        stringBuilder.append(" world");
        System.out.println(stringBuilder);

        // 链式编程
        // stringBuilder.append("asd").append(123).append(45.222);

        // 字符串反转
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(reverse);

        // StringBuilder --> String
        StringBuilder stringBuilder2 = new StringBuilder("asd");
        String string = stringBuilder2.toString();

        // 通过构造方法完成String --> StringBuilder
        String s1 = "hek";
        StringBuilder stringBuilder3 = new StringBuilder(s1);
    }
}
