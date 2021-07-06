package string;

import java.util.Scanner;

/**
 * 字符串的拼接
 *      使用string
 *      使用stringBuilder
 */
public class Demo6 {
    public static void main(String[] args) {

        // 使用String
        /*int [] a = {1, 2, 3};
        String s = "";
        s+="[";

        for (int i = 0; i < a.length; i++) {
            if (i == a.length-1){
                s+=a[i];
            }else {
                s+=a[i];
                s+=", ";
            }
        }

        s+="]";
        System.out.println(s);*/

        // 使用stringBuilder
        int [] a = {1, 2, 3};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < a.length; i++) {
            if (i == a.length-1){
                stringBuilder.append(a[i]);
            }else {
                stringBuilder.append(a[i]);
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        String s = stringBuilder.toString();
        System.out.println(s);

    }
}
