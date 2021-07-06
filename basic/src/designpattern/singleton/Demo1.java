package designpattern.singleton;

import org.junit.Test;

public class Demo1 {
    /**
     * 数组内数据循环平移
     *
     * @param arr        int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    @Test
    void test(){
        int [] a = new int[1];
        System.out.println(a[0]);
    }
    /*public int[] pushIntArray(int[] arr, int pushOffset) {
        // write code here
        int len = arr.length;
        int [] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            arr1[i] = arr[i];
        }


    }*/

}