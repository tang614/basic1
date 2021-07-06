package string;


import java.util.Scanner;

/**
 * 1、演示字符串不可变
 * 2、字符串的几种创建方法
 */
public class demo1 {
    public static void main(String[] args) {
        String s = "123";
        s = "234";
        System.out.println(s);  //234

        // 空参
        String string = new String();
        System.out.println(string);

        char [] chars = {'a', 'b', 'c'};
        String s1 = new String(chars);
        System.out.println(s1);

        byte [] bytes = {97, 98, 99};
        String s2 = new String(bytes);
        System.out.println(s2);

        String s3 = "123";
        System.out.println(s3);


    }
}
