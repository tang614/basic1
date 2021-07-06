package string;

import java.util.Scanner;

/**
 * 控制台输入一个字符串，判断大写字母、小写字母、数字的个数
 * 字符'a' 97
 * 'A' 65
 * '0' 48
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int i = 0;
        int j = 0;
        int k = 0;

        for (int i1 = 0; i1 < s.length(); i1++) {
            char c = s.charAt(i1);
            if (c >= 'A' && c <= 'Z')
                i++;
            if (c >= 'a' && c <= 'z')
                j++;
            if (c >= '0' && c <= '9')
                k++;
        }

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        /*int i = (int)'A';
        int j = (int)'a';
        int k = (int)'0';
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);*/

        boolean bc = "abc".endsWith("bc");
        System.out.println(bc);


    }
}
