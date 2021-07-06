package leedcode;

//二分查找
public class ErFen {
    public static void main(String[] args) {
        int [] data = {1, 3, 4, 6, 8, 23, 45, 87, 99};
        int index = 87; //要查找的数

        //定义开始和结束下标
        int beginPos = 0;
        int endPos = data.length-1;

        while (beginPos<=endPos) {
            //计算中间下标
            int midPos = (beginPos + endPos) / 2;
            if (index == data[midPos]) {
                System.out.println("目标数字的下标是" + midPos);
                return; //如果找到，return之间结束main函数
            }
            if (index > data[midPos]){
                beginPos = midPos+1;
            }
            if (index < data[midPos]){
                endPos = midPos-1;
            }
        }
        System.out.println("找不到目标数字");
    }
}
