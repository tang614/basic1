package arrays;

//数组的拷贝
public class Demo2 {
    public static void main(String[] args) {
        int [] src = {1, 2, 3, 4, 5, 6};
        int [] des = {4, 5, 6, 6, 0, 0};

        System.arraycopy(src, 0, des, 2, 3);

        for (int i = 0; i < des.length; i++)
            System.out.println(des[i]);
           //4, 5, 1, 2, 3, 0

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }   //1, 2, 3, 4, 5, 6





    }
}
