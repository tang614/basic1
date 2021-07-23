package org.example;

public class Main3 {
    public static void main(String[] args) {
        PoiOperator operator = new PoiOperator();
        String srcPath = "C:\\Users\\Administrator\\Downloads\\EXCEL导出样例(含免责声明样式) (2).xlsx";
        String descPath = "C:\\Users\\Administrator\\Desktop\\1234";
        operator.replace(srcPath,descPath);
    }
}
