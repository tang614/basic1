package thread.threadsafe;

public class a {
    public static void main(String[] args) {
        String str1 = new String("a"); //在堆内存中创建一个对象
        String str = "a";//在常量池中创建一个对象
        System.out.println(str == str1);

        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println(stringBuffer);
    }
}
