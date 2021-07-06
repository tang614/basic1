package leedcode;

//冒泡排序的算法
public class MaoPao {
    public static void main(String[] args) {
        int [] data = {1,3,2,8,34,3,0};

        for (int i=data.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if(data[j]>=data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
