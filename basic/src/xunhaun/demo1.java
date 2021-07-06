package xunhaun;

//break是指结束循环，continue是指不会执行本次循环体下面的语句
public class demo1 {
    public static void main(String[] args) {
        int i=3;


        /*while (i< 10){
            System.out.println(i);
            i++;
        }
        System.out.println(i);*/

        /*do {
            System.out.println(i);
            i++;
        }while (i<10);*/

        //关于case 和 default顺序问题，想找到i属于那种情况，找不到就是default,不管匹配到那种情况，执行该情况下的代码，如果有break,结束，
        // 没有的话按照代码从上往下的顺序执行所有的语句知道有break;
        switch (i){

            default:
                System.out.println("你输入有误");
            case 1:
                System.out.println(1);

            case 2:
                System.out.println(2);


        }


    }
}
