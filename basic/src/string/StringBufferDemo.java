package string;

/**
 * 基本用法和StringBuilder一样：
 *      StringBuffer的构造方法
 *      字符串拼接
 *      字符串反转
 *      加锁，速度慢
 *
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        // 无参构造 返回空字符串
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer);
        String string = stringBuffer.toString();
        System.out.println(string);

        String s = "hello";
        StringBuffer stringBuffer1 = new StringBuffer(s);
        System.out.println(stringBuffer1);
        StringBuffer stringBuffer2 = new StringBuffer("world");
        System.out.println(stringBuffer2);

        StringBuffer append = stringBuffer.append("123").append(345);
        System.out.println(append);

        StringBuffer reverse = append.reverse();
        System.out.println(reverse);

    }
}
