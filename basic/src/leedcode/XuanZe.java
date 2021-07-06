package leedcode;

//选择排序算法
public class XuanZe {
    public static void main(String[] args) {
        int [] data = {3, 4, 2, 34, 23, 0, 6};

        for (int i=0; i<data.length-1; i++){
            int min = data[i];
            for (int j=i+1; j<data.length; j++){
                if(data[j]<min){
                    int temp = data[j];
                    data[j] = min;
                    min = temp;
                }
            }
            data[i] = min;
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
