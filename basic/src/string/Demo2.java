package string;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //以 换行 为分隔符,回车表示结束
//        String s = scanner.nextLine();
//        String s1 = scanner.nextLine();
//
//        System.out.println("s: " + s);
//        System.out.println("s1: " + s1);
//
//        String s2 = scanner.nextLine();
//        System.out.println("s2: " + s2);

        // 空格 换行 为分隔符
//        String s = scanner.next();
//        String s1 = scanner.next();
//
//        System.out.println("s: " + s);
//        System.out.println("s1: " + s1);
//
//        String s2 = scanner.next();
//        System.out.println("s2: " + s2);

        // 空格 换行 都可以
//        int i = scanner.nextInt();
//        int i1 = scanner.nextInt();
//        System.out.println(i+i1);

        /*int i = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        String next = scanner1.next();

        scanner.close();
        scanner1.close();

        System.out.println(next);
        System.out.println(i);*/

        // 当输入#时结束，否则程序不暂停，要求一直输入
        while (!scanner.hasNext("#")){
            String s = scanner.next();
            System.out.println(s);
        }
    }
}
