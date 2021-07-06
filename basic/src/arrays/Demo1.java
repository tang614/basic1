package arrays;

import java.util.Arrays;

//数组的比较
public class Demo1 {

    //自定义比较方法
    public static boolean isEquals(int [] a,int [] b){

        if (a == null || b == null){
            return false;
        }
        if (a.length != b.length){
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [] a = {1, 2, 3};
        int [] b = {1, 2, 3};
        System.out.println(a.equals(b));   //false

        //使用工具类Arrays
        System.out.println(Arrays.equals(a,b));   //true

        //使用自定义比较方法
        System.out.println(isEquals(a,b));  //true

        int [][] ab = {{1,2},{2,3},{3,4}};
        int length = ab[0].length;
        System.out.println(length);
    }

}
